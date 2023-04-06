package cn.chenzw.springboot.security.basic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 权限错误
     *
     * @return
     */
    @GetMapping("/403")
    public String error() {
        return "403";
    }

}
