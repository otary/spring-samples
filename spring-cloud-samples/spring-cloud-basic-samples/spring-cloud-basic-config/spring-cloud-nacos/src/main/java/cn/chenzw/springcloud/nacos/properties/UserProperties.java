package cn.chenzw.springcloud.nacos.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties不用使用@RefreshScope
 */
@Component
@ConfigurationProperties(prefix = "my")
public class UserProperties {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
