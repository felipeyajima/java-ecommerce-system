package com.barretoeyajima_ecommerce.import_products;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    @Bean
    public Job processarProduct(JobRepository jobRepository, Step step){
        return new JobBuilder("importProduct", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager platformTransactionManager,
                     ItemReader<Product> itemReader,
                     ItemWriter<Product> itemWriter,
                     ItemProcessor<Product, Product> itemProcessor){
        return new StepBuilder("step", jobRepository)
                .<Product, Product>chunk(1, platformTransactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public ItemReader<Product> itemReader(){
        BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Product.class);
        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                .resource(new ClassPathResource("products.csv"))
                .delimited()
                .names("id", "name", "description", "price", "category", "imageUrl", "sku", "brand", "weight", "available", "stockLevel")
                .fieldSetMapper(fieldSetMapper)
                .build();
    }
    @Bean
    public ItemWriter<Product>  itemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .dataSource(dataSource)
                .sql("INSERT INTO products "
                        + "(id,name,description,price,category,imageUrl,sku,brand,weight,available,stockLevel)"
                        + "VALUES (:id, :name, :description, :price, :category,:imageUrl, :sku, :brand, :weight, :available, :stockLevel)")
                .build();
    }
    @Bean
    public ItemProcessor<Product, Product> itemProcessor(){
        return new ProductProcessor();
    }


}
