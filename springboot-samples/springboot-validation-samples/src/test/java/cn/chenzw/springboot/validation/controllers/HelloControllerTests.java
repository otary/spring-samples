package cn.chenzw.springboot.validation.controllers;

import cn.chenzw.springboot.validation.ValidationSamplesApp;
import cn.chenzw.springboot.validation.domain.dto.UserBodyParamDto;
import cn.chenzw.springboot.validation.domain.dto.UserParamDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolationException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ValidationSamplesApp.class})
@WebAppConfiguration
public class HelloControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test // (expected = BindException.class)
    public void throwBindException() throws Exception {
        UserParamDto userParamDto = new UserParamDto();

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(userParamDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/hello/throw-bind-exception").content(body))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(print());
    }

    @Test  // (expected = MethodArgumentNotValidException.class)
    public void testThrowMethodArgumentNotValidException() throws Exception {
        UserBodyParamDto userBodyParamDto = new UserBodyParamDto();

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(userBodyParamDto);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/hello/throw-method-argument-not-valid-exception").content(body)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(print());
    }

    @Test // (expected = ConstraintViolationException.class)
    public void testThrowConstraintViolationException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/throw-constraint-violation-exception"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test //(expected = ConstraintViolationException.class)
    public void testThrowConstraintViolationException2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/throw-constraint-violation-exception2"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(print());
    }

}
