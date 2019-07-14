# spring-annotation-aware-samples

aware、initializer示例

#### 接口

> 生命周期
- SmartLifecycle
- WebInitializer

> 回调函数
- BeanNameAware
- BeanFactoryAware
- ResourceLoaderAware
- MessageSourceAware
- ApplicationContextAware
- ServletContextAware

#### 运行

`$ mvn tomcat7:run`


```
---------WebInitializer startup---------------
---------WebInitializer2 startup---------------

- BeanNameAware:appBean
- BeanFactoryAware:org.springframework.beans.factory.support.DefaultListableBeanFactory@7ba18f1b: defining beans [org.springframework.context.annotation.internalConfigurationAnn
otationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.sprin
gframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventL
istenerFactory,appConfig,appBean]; root of factory hierarchy
- ResourceLoaderAware:org.springframework.web.context.support.GenericWebApplicationContext@5e3a8624: startup date [Sat Jul 13 12:57:10 CST 2019]; root of context hierarchy
- MessageSourceAware:org.springframework.web.context.support.GenericWebApplicationContext@5e3a8624: startup date [Sat Jul 13 12:57:10 CST 2019]; root of context hierarchy
- ApplicationContextAware:org.springframework.web.context.support.GenericWebApplicationContext@5e3a8624: startup date [Sat Jul 13 12:57:10 CST 2019]; root of context hierarchy
- ServletContextAware:org.springframework.mock.web.MockServletContext@6f96c77

----------SmartLifeStyle start--------------

```
