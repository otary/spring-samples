package cn.chenzw.springboot.web.advice;

import cn.chenzw.springboot.web.advice.annotation.ResponseBodyBase64;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Base64;

/**
 * 响应值自定义处理
 * @author chenzw
 */
@RestControllerAdvice // (basePackages = {"cn.chenzw.springboot.web"})
public class ReponseBodyBase64Advice implements ResponseBodyAdvice<Object> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(ResponseBodyBase64.class) || returnType.hasParameterAnnotation(ResponseBodyBase64.class);
    }


    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            return body;
        }

        return new String(Base64.getEncoder().encode(jsonStr.getBytes()));
    }

}
