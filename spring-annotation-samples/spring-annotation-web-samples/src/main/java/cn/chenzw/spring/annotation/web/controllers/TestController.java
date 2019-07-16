package cn.chenzw.spring.annotation.web.controllers;

import cn.chenzw.toolkit.logging.LogbackUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

     static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/list")
    public void test(){
       /* List<LoggerConfig> loggerConfigs = Log4j2Utils.getLoggerConfigs();

        System.out.println(loggerConfigs);

        for (LoggerConfig loggerConfig : loggerConfigs) {
            System.out.println(loggerConfig.getName() + ":" + loggerConfig.getLevel());
        }*/

        List<ch.qos.logback.classic.Logger> loggers = LogbackUtils.getLoggers();
        System.out.println(loggers);
    }
}
