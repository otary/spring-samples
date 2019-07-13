package cn.chenzw.spring.annotation.aware.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * 需要在META-INF/services/javax.servlet.ServletContainerInitializer中进行注册
 */
@HandlesTypes(WebApplicationInitializer.class)
public class CustomWebInitializers implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> webApplicationInitializerClassSet, ServletContext servletContext) throws ServletException {
        for (Class<?> webApplicationInitializer : webApplicationInitializerClassSet) {
            System.out.println("-------------- webApplicationInitializer init -----------------");
        }
    }
}
