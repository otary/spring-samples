package cn.chenzw.spring.annotation.aware.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer2 implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("---------WebInitializer2 startup---------------");
    }
}
