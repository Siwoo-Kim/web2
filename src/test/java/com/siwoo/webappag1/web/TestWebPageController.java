package com.siwoo.webappag1.web;

import com.siwoo.webappag1.domain.WebPage;
import com.siwoo.webappag1.repository.WebPageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestWebPageController {

    @Autowired WebApplicationContext webapp;
    MockMvc mockMvc;
    @Autowired WebPageRepository webPageRepository;
    HttpMessageConverter messageConverter;
    MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("UTF-8"));

    @Autowired
    public void set(List<HttpMessageConverter> messageConverters) {
        messageConverter = messageConverters.stream()
                .filter(messageConverter -> messageConverter instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .get();
    }

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webapp).build();
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/webPage"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(mediaType))
                .andExpect(jsonPath("$",iterableWithSize((int) webPageRepository.count())))
                .andDo(print());
    }

    @Test
    public void save() throws Exception {
        WebPage webPage = new WebPage();
        webPage.setName("TEST1");
        mockMvc.perform(post("/webPage").contentType(mediaType).content(toJsonString(webPage)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(mediaType));
        assertNotNull(webPageRepository.findByName("TEST1"));
    }

    public String toJsonString(Object object) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage= new MockHttpOutputMessage();
        this.messageConverter.write(object, mediaType, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
