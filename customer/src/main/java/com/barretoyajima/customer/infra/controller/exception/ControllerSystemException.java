package com.barretoyajima.customer.infra.controller.exception;

public class ControllerSystemException extends RuntimeException{
    public ControllerSystemException(String message){
        super(message);
    }
}
