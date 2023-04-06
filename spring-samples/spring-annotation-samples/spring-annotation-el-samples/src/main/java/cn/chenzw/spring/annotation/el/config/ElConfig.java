package cn.chenzw.spring.annotation.el.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;


@Configuration
@ComponentScan({"cn.chenzw.spring.annotation.el"})
@PropertySource({"classpath:config.properties"})
public class ElConfig {

    @Value("张三")
    private String name;

    @Value("25")
    private Integer age;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100}")
    private double randomNumber;

    @Value("classpath:config.properties")
    private Resource resourceFile;

    @Value("http://www.baidu.com")
    private Resource resourceUrl;


    @Value("${user.passowrd}")
    private String password;


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

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Resource getResourceFile() {
        return resourceFile;
    }

    public void setResourceFile(Resource resourceFile) {
        this.resourceFile = resourceFile;
    }

    public Resource getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(Resource resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ElConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", osName='" + osName + '\'' +
                ", randomNumber=" + randomNumber +
                ", resourceFile=" + resourceFile +
                ", resourceUrl=" + resourceUrl +
                ", password='" + password + '\'' +
                '}';
    }
}
