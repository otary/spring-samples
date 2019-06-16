package cn.chenzw.spring.annotation.aware.initializer;

import cn.chenzw.spring.annotation.aware.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Servlet 3.0+
 *
 * @author chenzw
 */
public class WebInitizlizer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
        wac.register(AppConfig.class);
        wac.setServletContext(servletContext);

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(wac));
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);

        System.out.println("---------startup---------------");

    }
}
