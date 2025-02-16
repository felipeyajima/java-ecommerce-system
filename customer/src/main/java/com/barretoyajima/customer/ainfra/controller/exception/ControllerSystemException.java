package com.barretoyajima.customer.ainfra.controller.exception;

public class ControllerSystemException extends RuntimeException{
    public ControllerSystemException(String message){
        super(message);
    }
}
