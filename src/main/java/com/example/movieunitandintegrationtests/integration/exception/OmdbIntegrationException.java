package com.example.movieunitandintegrationtests.integration.exception;

public class OmdbIntegrationException extends RuntimeException {
    protected final OmdbIntegrationErrorCodeEnum errorCode;
    protected final String message;

    public OmdbIntegrationException(OmdbIntegrationErrorCodeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public OmdbIntegrationErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
