package cn.chenzw.spring.mvc.arguments.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/hello")
public class HelloRestController {

    /**
     * 获取请求参数
     *
     * @param foo
     * @return
     */
    @GetMapping("/param")
    public String withParam(@RequestParam String foo) {
        return "Obtained query parameter value '" + foo + "'";
    }

    /**
     * 获取请求头部
     *
     * @param accept
     * @return
     */
    @GetMapping("/header")
    public String withHeader(@RequestHeader("user-agent") String userAgent, @RequestHeader String accept, @RequestHeader Map<String, String> headers) {
        return "Obtained 'Accept' header '" + accept + "', 'use-agent' header '" + userAgent + "'";
    }

    /**
     * 获取cookie值
     *
     * @param cookieSession
     * @return
     */
    @GetMapping("/cookie")
    public String withCookie(@CookieValue("COOKIE_SESSION") String cookieSession) {
        return "Obtained 'COOKIE_SESSION' cookie '" + cookieSession + "'";
    }

    /**
     * HttpEntity接收
     *
     * @param entity
     * @return
     */
    @PostMapping("/entity")
    public String withEntity(HttpEntity<String> entity) {
        return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
    }

    @GetMapping("/entity")
    public String withEntity2(HttpEntity<String> entity) {
        return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
    }


    /**
     * maxtrixVariable示例
     *
     * @param path1
     * @param jsessionid
     * @return
     * @see {urlPathHelper.setRemoveSemicolonContent(false);}
     */
    @GetMapping("/{path1}/simple")
    public String withMatrixVariable(@PathVariable String path1,String jsessionid) {
        return "Obtained matrix variable 'jsessionid=" + jsessionid + "' from path segment '" + path1 + "'";
    }

    //@MatrixVariable(name = "jsessionid", pathVar = "path1")
}
