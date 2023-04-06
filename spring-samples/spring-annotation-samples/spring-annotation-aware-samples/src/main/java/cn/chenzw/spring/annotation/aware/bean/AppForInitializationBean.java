package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AppForInitializationBean implements InitializingBean, SmartInitializingSingleton {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----- InitializingBean:" + applicationContext);
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("----- SmartInitializingSingleton:" + applicationContext);
    }
}
