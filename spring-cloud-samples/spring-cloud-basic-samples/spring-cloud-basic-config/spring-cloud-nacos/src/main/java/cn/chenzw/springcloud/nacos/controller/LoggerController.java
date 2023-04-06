package cn.chenzw.springcloud.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 可以在nacos中修改logging.level配置项动态修改日志级别
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LoggerController {

    @GetMapping
    public void log() {
        log.trace("==> trace");
        log.debug("==> debug");
        log.info("==> info");
        log.error("==> error");
    }
}
