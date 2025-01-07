package com.verodigit.interview.exception;

import lombok.Getter;

public class APIException extends Exception {

    @Getter
    private final String message;

    public APIException(String error) {
        super();
        this.message = error;
    }

}
