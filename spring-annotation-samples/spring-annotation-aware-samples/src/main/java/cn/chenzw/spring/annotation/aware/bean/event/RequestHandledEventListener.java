package cn.chenzw.spring.annotation.aware.bean.event;

import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.RequestHandledEvent;

public class RequestHandledEventListener implements ApplicationListener<RequestHandledEvent> {

    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
        System.out.println("--- RequestHandledEvent ==>" + event);
    }
}
