package com.atkison.atkison2018.configurations;

import org.springframework.web.bind.annotation.ResponseStatus;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String exception)
    {
        super(exception);
    }
}
