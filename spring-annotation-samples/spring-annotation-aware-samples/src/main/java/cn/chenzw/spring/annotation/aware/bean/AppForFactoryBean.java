package cn.chenzw.spring.annotation.aware.bean;

import org.springframework.beans.factory.FactoryBean;

public class AppForFactoryBean implements FactoryBean<AppForFactoryBean.MyBean> {
    @Override
    public MyBean getObject() throws Exception {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public static class MyBean {

        public String getMessage() {
            return "This is myBean";
        }
    }
}

