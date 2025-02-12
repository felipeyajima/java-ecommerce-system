package com.barretoyajima.worker.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "bill-api")
public interface PaymentSituationClient {

    @GetMapping("/bills/{id}/is-paid")
    boolean getSituation(@PathVariable("id")UUID id);

}
