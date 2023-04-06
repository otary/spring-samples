package cn.chenzw.springboot.aop.controller;

import cn.chenzw.springboot.aop.support.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @SysLog
    @GetMapping("/info")
    public String getUserInfo(String userId) {
        log.info("主线程ID => {}", Thread.currentThread().getId());
        return "张三";
    }
}
