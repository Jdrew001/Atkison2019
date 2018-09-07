package com.atkison.atkison2018.configurations;

import org.springframework.web.bind.annotation.ResponseStatus;

public class EmailFoundException extends RuntimeException {
    public EmailFoundException(String exception)
    {
        super(exception);
    }
}
