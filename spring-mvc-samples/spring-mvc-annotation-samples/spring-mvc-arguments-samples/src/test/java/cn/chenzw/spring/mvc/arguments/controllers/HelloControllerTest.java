package cn.chenzw.spring.mvc.arguments.controllers;

import cn.chenzw.spring.mvc.arguments.config.AppConfig;
import cn.chenzw.spring.mvc.arguments.config.WebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class HelloControllerTest {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testWithParam() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/rest/hello/param").param("foo", "fooValue"))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("Obtained query parameter value 'fooValue'", content);
    }

    @Test
    public void testWithHeader() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/rest/hello/header")
                .header("accept", "text/html,application/xhtml+cn.chenzw.spring.mvc.xml,application/cn.chenzw.spring.mvc.xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                .header("host", "localhost:8080")
                .header("connection", "keep-alive")
                .header("cache-control", "max-age=0")
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("Obtained 'Accept' header 'text/html,application/xhtml+cn.chenzw.spring.mvc.xml,application/cn.chenzw.spring.mvc.xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3', 'use-agent' header 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36'", content);
    }


    @Test
    public void testWithCookie() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/rest/hello/cookie")
                .cookie(new Cookie("COOKIE_SESSION", "4926_0_8_8_2_1_0_0_8_1_0_0_40114_0_0_0"))
                .cookie(new Cookie("BAIDUID", "AB2CE2C5D085082D5E01395E7E57A246"))
        ).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("Obtained 'COOKIE_SESSION' cookie '4926_0_8_8_2_1_0_0_8_1_0_0_40114_0_0_0'", content);
    }

    @Test
    public void testWithEntity() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/rest/hello/entity").content("{id:1}"))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("Posted request body '{id:1}'; headers = {Content-Length=[6]}", content);
    }

    @Test
    public void testWithEntity2() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/rest/hello/entity").content("{id:1}"))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("Posted request body '{id:1}'; headers = {Content-Length=[6]}", content);
    }

    @Test
    public void testWithMatrixVariable() throws Exception {
       /* MvcResult mvcResult = this.mockMvc.perform(get("/rest/hello/matrixvars;jsessionid=node01uy3s2v42dep/simple"))
                .andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();*/

    }


}
