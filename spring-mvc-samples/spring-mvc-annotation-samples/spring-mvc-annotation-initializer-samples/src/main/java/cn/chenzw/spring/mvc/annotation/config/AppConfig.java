package cn.chenzw.spring.mvc.annotation.config;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class AppConfig {


    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        //annotationConfigApplicationContext.scan("cn.chenzw.spring.sample.*");

		
		/*ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(annotationConfigApplicationContext);
		Set<BeanDefinition> findCandidateComponents = classPathBeanDefinitionScanner.findCandidateComponents("cn.chenzw.spring.sample.*");
		System.out.println(findCandidateComponents);*/
		
		/*String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}*/

        //BeanDefinition beanDefinition = annotationConfigApplicationContext.getBeanDefinition("userService");
		
		/*Method[] methods = BeanDefinition.class.getMethods();
		for (Method method : methods) {
			System.out.println(method);
			if(method.getParameterTypes().length == 0){
				Object invoke = method.invoke(beanDefinition, null);
				System.out.println(invoke);
			}
			
		}*/

        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver("/WEB-INF/",
                ".jsp");
        internalResourceViewResolver.setApplicationContext(annotationConfigApplicationContext);

        View viewName = internalResourceViewResolver.resolveViewName("test", null);
        InternalResourceView view2 = (InternalResourceView) viewName;
		
		
		
		/*AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(WebConfig.class);
		annotationConfigWebApplicationContext.scan("cn.chenzw.spring.sample.*");
		annotationConfigWebApplicationContext.refresh();
		String[] beanDefinitionNames = annotationConfigWebApplicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}*/


    }

}
