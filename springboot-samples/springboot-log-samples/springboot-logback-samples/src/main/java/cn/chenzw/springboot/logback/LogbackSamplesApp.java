package cn.chenzw.springboot.logback;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LogbackSamplesApp {

    private static Marker marker = MarkerFactory.getMarker("MY_MARKER");

    public static void main(String[] args) {
        SpringApplication.run(LogbackSamplesApp.class, args);

        log.info(marker, "MY_MARKER标签日志输出...");
    }


}
