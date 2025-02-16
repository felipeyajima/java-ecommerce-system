package com.barretoyajima.customer.ainfra.controller.exception;

import lombok.Data;

import java.time.Instant;

@Data

public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(){}

}
