package com.barretoeyajima.ecommerce.product.controller.exception;

public class ControllerNotFoundException extends RuntimeException{
    public ControllerNotFoundException(String message){
        super(message);
    }
}
