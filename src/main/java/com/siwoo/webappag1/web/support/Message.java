package com.siwoo.webappag1.web.support;

import lombok.Getter;
import lombok.ToString;

@ToString @Getter
public class Message {

    private String message;
    private boolean isError;

    public Message(String message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }

}
