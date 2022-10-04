package com.asd.backened.common;

/**
 * Exceptionally tired custom business
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
