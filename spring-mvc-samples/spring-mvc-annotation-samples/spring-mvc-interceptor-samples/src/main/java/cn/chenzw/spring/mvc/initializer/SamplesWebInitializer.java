package cn.chenzw.spring.mvc.initializer;

import cn.chenzw.spring.mvc.filter.Samples2Filter;
import cn.chenzw.spring.mvc.filter.SamplesFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class SamplesWebInitializer implements WebApplicationInitializer {


    /**
     * 动态添加Servlet、Filter、Listener
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        FilterRegistration.Dynamic samplesFilter = servletContext.addFilter("samplesFilter", SamplesFilter.class);
        samplesFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");


        FilterRegistration.Dynamic samples2Filter = servletContext.addFilter("samples2Filter", Samples2Filter.class);
        samples2Filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");

    }
}
