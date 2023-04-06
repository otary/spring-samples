package cn.chenzw.spring.mvc.context.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/context")
public class ContextController {

    @GetMapping("/list")
    public void list(HttpServletRequest request) {
        // web子容器
        WebApplicationContext webContext = RequestContextUtils.findWebApplicationContext(request);
        System.out.println("-- webContext: " + webContext);

        // 根容器
        WebApplicationContext rootContext = ContextLoader.getCurrentWebApplicationContext();
        System.out.println("-- rootContext: " + rootContext);

        // 根容器
        WebApplicationContext rootContext2 =
                WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        System.out.println("-- rootContext2: " + rootContext2);
    }
}
