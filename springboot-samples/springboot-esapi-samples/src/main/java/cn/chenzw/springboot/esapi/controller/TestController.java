package cn.chenzw.springboot.esapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.EncodingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzw
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    public void test() throws EncodingException {
        String url = ESAPI.encoder().encodeForURL("https://www.baidu.com");
        log.info("url => {}", url);
    }

}
