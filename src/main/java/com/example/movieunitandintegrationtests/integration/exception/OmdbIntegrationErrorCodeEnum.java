package com.example.movieunitandintegrationtests.integration.exception;

public enum OmdbIntegrationErrorCodeEnum {
    TITLE_NOT_FOUND("TITLE_NOT_FOUND");

    private String errorCode;

    OmdbIntegrationErrorCodeEnum(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
