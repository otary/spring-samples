package cn.chenzw.spring.annotation.aware.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Servlet 3.0+
 *
 * @author chenzw
 */
public class WebInitizlizer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("-----------------------");
    }
}
