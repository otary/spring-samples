package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AppForInitializationBean implements InitializingBean {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----- InitializingBean:" + applicationContext);
    }
}
