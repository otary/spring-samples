package cn.chenzw.spring.annotation.profile.template;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("fj")
@Component
public class FJSSOTemplate implements SSOTemplate, InitializingBean {
    @Override
    public void login() {

    }

    @Override
    public String getName() {
        return "福建单点";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-------------fj----------");
    }
}
