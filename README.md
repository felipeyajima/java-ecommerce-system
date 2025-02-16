# java-ecommerce-system

[![OpenAPI](https://img.shields.io/badge/CLEAN%20ARCHITECTURE-8A2BE2)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/JAVA-FC6A31)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/DOCKER-2496ED)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/SPRING%20BOOT-FC6A31)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/OPEN%20API-EF0092)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/POSTGRESQL-8A2BE2)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/SPRING%20DATA%20JPA-FC6A31)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/IN%20MEMORY%20H2%20DATABASE-00EA64)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/TESTS-8A2BE2)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/OPEN%20FEIGN-00EA64)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/CLOUD%20STREAM-2496ED)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/RABBITMQ-FC6A31)](https://www.openapis.org/)
[![OpenAPI](https://img.shields.io/badge/SPRING%20CLOUD%20BATCH-FC6A31)](https://www.openapis.org/)


#### Architecture overview
![Booking Call](ecommerce.png)


#### Order response example


```json

{
    "id": "f0bbe760-0343-423a-bc03-0ffa294d7e82",
    "customer": {
        "id": 1,
        "customerId": "39b52402-6799-4dfb-bac3-b19692eee181",
        "name": "Felipe Batista",
        "documentNumber": "333.333.333-33"
    },
    "productList": [
        {
            "id": 1,
            "name": "T-Shit Conf - Yellow",
            "productId": "00302bb6-173c-4958-b313-5bdd7494d1ff",
            "price": 12.0,
            "quantity": 2,
            "sku": "1KD-5",
            "brand": "Adidas"
        },
        {
            "id": 2,
            "name": "Galaxy S34",
            "productId": "ec1a94ec-14d2-4bd7-a4d3-01b068866163",
            "price": 420.0,
            "quantity": 1,
            "sku": "4FD-5",
            "brand": "Samsung"
        }
    ],
    "orderDateRequested": "2025-02-16T12:44:44.976134",
    "totalWeight": 0.2,
    "totalAmount": 444.0,
    "deliveryEstimation": "2025-02-17T12:44:44.976134",
    "payment": {
        "id": 1,
        "bill": "7a48df3f-5cf9-4f84-be38-f5e9e357c1a9"
    },
    "delivery": {
        "id": 1,
        "delivery": "dbfae50e-39d7-4e08-8b7b-b39c1ada12ac"
    },
    "deliveryAddress": {
        "id": "16624c80-df55-4080-9842-e8568d71312b",
        "postalCode": "00000000",
        "place": "Rua dos Alfeneiros",
        "number": "1",
        "complement": "sem complemento"
    },
    "deliveryPrice": 10.0,
    "status": "PAID"
}

```
