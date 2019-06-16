package cn.chenzw.spring.annotation.profile.template;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("zj")
@Component
public class ZJSSOTemplate implements SSOTemplate {

    @Override
    public void login() {

    }

    @Override
    public String getName() {
        return "浙江单点";
    }
}
