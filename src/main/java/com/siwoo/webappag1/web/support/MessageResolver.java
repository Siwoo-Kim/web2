package com.siwoo.webappag1.web.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Locale;

@Slf4j
@Service
public class MessageResolver implements MessageSourceAware{
    public static final String CODE_ERROR_PREFIX = "error";
    @JsonIgnore
    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Message getMessage(String code, Locale locale) {
        Boolean isError = CODE_ERROR_PREFIX.equals(code.split("\\.")[0]);
        String message = messageSource.getMessage(code, null, locale);
        return new Message(message, isError);
    }

}
