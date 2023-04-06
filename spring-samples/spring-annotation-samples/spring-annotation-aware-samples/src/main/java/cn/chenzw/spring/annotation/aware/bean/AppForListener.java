package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

public class AppForListener implements ApplicationListener<ContextRefreshedEvent>{

    /**
     * 容器刷新事件
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("---- ApplicationListener:" + event.getApplicationContext());
    }
}
