# spring-mvc-interceptor-samples

拦截器示例


#### 访问

http://localhost:8080/index

#### 执行顺序

```
cn.chenzw.spring.mvc.filter.SamplesFilter - doFilterInternal - - doFilterInternal
cn.chenzw.spring.mvc.filter.Samples2Filter - doFilter - - doFilter
cn.chenzw.spring.mvc.interceptor.SamplesHandlerInterceptor - preHandle - - preHandle...
cn.chenzw.spring.mvc.interceptor.Samples2HandlerInterceptor - preHandle - - preHandle...
cn.chenzw.spring.mvc.interceptor.Samples2HandlerInterceptor - postHandle - - postHandle...
cn.chenzw.spring.mvc.interceptor.SamplesHandlerInterceptor - postHandle - - postHandle...
cn.chenzw.spring.mvc.interceptor.Samples2HandlerInterceptor - afterCompletion - - afterCompletion...
cn.chenzw.spring.mvc.interceptor.SamplesHandlerInterceptor - afterCompletion - - afterCompletion...
```