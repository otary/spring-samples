package cn.chenzw.spring.cloud.basic.security.resource.server.controllers;

import cn.chenzw.spring.cloud.basic.security.resource.server.dto.Instance;
import cn.chenzw.spring.cloud.basic.security.resource.server.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@RestController
public class ResourceController {

    private final static Logger logger = LoggerFactory.getLogger(ResourceController.class);


    private final static String DEFAULT_NAME = "xuan";

    private static String DEFAULT_SERVICE_ID = "application";

    private static String DEFAULT_HOST = "localhost";

    private static int DEFAULT_PORT = 8080;

    BearerTokenExtractor tokenExtractor = new BearerTokenExtractor();

   /* @Autowired
    ResourceServerTokenServices tokenServices;*/

    // 受保护的资源
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable("userId") String userId) {
        return new User(userId, DEFAULT_NAME);
    }

    // 不受保护的资源
    @GetMapping("/instance/{serviceId}")
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
        return new Instance(serviceId, DEFAULT_HOST, DEFAULT_PORT);
    }

   /* @GetMapping("/user")
    public Principal userInfo(ServletRequest req) throws IOException {
        Authentication authentication = tokenExtractor.extract((HttpServletRequest) req);
        String token = (String) authentication.getPrincipal();
        OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(token);
        return oAuth2Authentication;

    }*/

}
