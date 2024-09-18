package com.example.FlowMailApi.exception;

public class SpamException extends RuntimeException {
    public SpamException(String message) {
        super(message);
    }
}
