package cn.chenzw.springboot.web.properties.processor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 自定义修改Properties属性值 -- 常用于数据库密码加密、解密等
 */
@Component
public class CustModifyPropertiesProcessor implements BeanFactoryPostProcessor, EnvironmentAware, PriorityOrdered {

    private static final AtomicBoolean INITIALIZED = new AtomicBoolean(false);

    private ConfigurableEnvironment environment;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (INITIALIZED.compareAndSet(false, true)) {
            initializePropertySources();
        }
    }


    private void initializePropertySources() {
        this.decryptPasswd();
    }

    private void decryptPasswd() {
        CompositePropertySource composite = new CompositePropertySource("plain-password");
        Properties properties = new Properties();

        String passwd = this.environment.getProperty("cust.passwd");
        if (StringUtils.isNotBlank(passwd)) {
            String plainPasswd = new String(Base64.getMimeDecoder().decode(passwd));
            properties.put("cust.passwd", plainPasswd);
        }

        composite.addPropertySource(new PropertiesPropertySource("plain-password", properties));
        this.environment.getPropertySources().addFirst(composite);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public int getOrder() {
        // 优先级最高
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
