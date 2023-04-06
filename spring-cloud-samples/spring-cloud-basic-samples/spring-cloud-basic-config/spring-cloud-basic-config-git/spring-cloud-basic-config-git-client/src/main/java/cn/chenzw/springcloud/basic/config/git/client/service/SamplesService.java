package cn.chenzw.springcloud.basic.config.git.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SamplesService {

    @Value("${a}")
    private Integer a;

    @Value("${b}")
    private Integer b;

    public String print(){
        return a + "@" + b;
    }
}
