package cn.chenzw.spring.mvc.annotation.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author chenzw
 */
public class ServletContextIntializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("---------------onStartup----------------------");

		/*
		// 此处可以使用代码进行容器加载和初始化
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		//String profile = properties.getProperty("spring.profile", "default");
		//rootContext.getEnvironment().setActiveProfiles(profile);
		rootContext.refresh();
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");
		*/
    }

}
