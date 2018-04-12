package com.siwoo.webappag1.web;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestWebPageController {

//    @Autowired WebApplicationContext webapp;
//    MockMvc mockMvc;
//    @Autowired WebPageRepository webPageRepository;
//    HttpMessageConverter messageConverter;
//    MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("UTF-8"));
//
//    @Autowired
//    public void set(List<HttpMessageConverter> messageConverters) {
//        messageConverter = messageConverters.stream()
//                .filter(messageConverter -> messageConverter instanceof MappingJackson2HttpMessageConverter)
//                .findAny()
//                .get();
//    }
//
//    @Before
//    public void setup() {
//        mockMvc = webAppContextSetup(webapp).build();
//    }
//
//    @Test
//    public void list() throws Exception {
//        mockMvc.perform(get("/webPage"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(mediaType))
//                .andExpect(jsonPath("$",iterableWithSize((int) webPageRepository.count())))
//                .andDo(print());
//    }
//
//    @Test
//    public void save() throws Exception {
//        WebPage webPage = new WebPage();
//        webPage.setName("TEST1");
//        mockMvc.perform(post("/webPage").contentType(mediaType).content(toJsonString(webPage)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(mediaType));
//        assertNotNull(webPageRepository.findByName("TEST1"));
//    }
//
//    public String toJsonString(Object object) throws IOException {
//        MockHttpOutputMessage mockHttpOutputMessage= new MockHttpOutputMessage();
//        this.messageConverter.write(object, mediaType, mockHttpOutputMessage);
//        return mockHttpOutputMessage.getBodyAsString();
//    }
}
