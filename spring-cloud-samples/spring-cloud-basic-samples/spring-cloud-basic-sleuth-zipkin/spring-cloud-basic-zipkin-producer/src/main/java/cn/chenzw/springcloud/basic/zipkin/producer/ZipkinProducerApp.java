package cn.chenzw.springcloud.basic.zipkin.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZipkinProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinProducerApp.class, args);
    }
}
