package cn.chenzw.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * @Value注入，需要加@RefreshScope才能实时监听变化
     */
    @Value("${user.name}")
    private String name;

    @GetMapping("/getName")
    public String getName() {
        return name;
    }
}
