package com.siwoo.webappag1.web;

import com.siwoo.webappag1.web.support.Message;
import com.siwoo.webappag1.web.support.MessageResolver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMessage {

    @Autowired
    MessageResolver messageResolver;

    @Test
    public void resolveMessage() {
        assertNotNull(messageResolver);

        Message message = messageResolver.getMessage("home.greeting",Locale.KOREA);
        assertFalse(message.isError());
        message = messageResolver.getMessage("error.notFound.topic.id",Locale.KOREA);
        assertTrue(message.isError());
    }
}
