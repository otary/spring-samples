# spring-cloud-samples

![springcloud](https://img.shields.io/badge/springcloud-Greenwich.RELEASE-brightgreen.svg)
![springboot](https://img.shields.io/badge/springboot-2.1.2.RELEASE-brightgreen.svg)
![jdk](https://img.shields.io/badge/jdk-1.8-yellowgreen.svg)
![LICENSE](https://img.shields.io/badge/LICENSE-Apache%202.0-yellow.svg)


- [spring-cloud-basic-eureka](./spring-cloud-basic-samples/spring-cloud-basic-eureka): 服务注册与发现中心
  - [spring-cloud-basic-eureka-server](./spring-cloud-basic-samples/spring-cloud-basic-eureka/spring-cloud-basic-eureka-server)：注册中心
  - [spring-cloud-basic-eureka-client](./spring-cloud-basic-samples/spring-cloud-basic-eureka/spring-cloud-basic-eureka-client)：服务提供者
- [spring-cloud-basic-discovery](./spring-cloud-basic-samples/spring-cloud-basic-discovery): 服务消费者
  - [spring-cloud-basic-ribbon](./spring-cloud-basic-samples/spring-cloud-basic-discovery/spring-cloud-basic-ribbon): ribbon消费方式
  - [spring-cloud-basic-feign](./spring-cloud-basic-samples/spring-cloud-basic-discovery/spring-cloud-basic-feign)：feign消费方式
- [spring-cloud-basic-zuul](./spring-cloud-basic-samples/spring-cloud-basic-zuul): 网关/路由
- [spring-cloud-basic-gateway](./spring-cloud-basic-samples/spring-cloud-basic-gateway): 网关/路由
- [spring-cloud-basic-config](./spring-cloud-basic-samples/spring-cloud-basic-config): 配置中心
  - [spring-cloud-basic-config-git](./spring-cloud-basic-samples/spring-cloud-basic-config/spring-cloud-basic-config-git)：基于git仓库的配置中心
    - [spring-cloud-basic-config-git-server](./spring-cloud-basic-samples/spring-cloud-basic-config/spring-cloud-basic-config-git/spring-cloud-basic-config-git-server): 基于git仓库的配置中心服务端
    - [spring-cloud-basic-config-git-client](./spring-cloud-basic-samples/spring-cloud-basic-config/spring-cloud-basic-config-git/spring-cloud-basic-config-git-client): 基于git仓库的配置中心客户端
- [spring-cloud-basic-sleuth-zipkin](./spring-cloud-basic-samples/spring-cloud-basic-sleuth-zipkin): 调用链监控
    - [spring-cloud-basic-sleuth-zipkin-producer](./spring-cloud-basic-samples/spring-cloud-basic-sleuth-zipkin/spring-cloud-basic-zipkin-producer): 
    - [spring-cloud-basic-sleuth-zipkin-consumer](./spring-cloud-basic-samples/spring-cloud-basic-sleuth-zipkin/spring-cloud-basic-zipkin-consumer): 
- [spring-cloud-basic-security](./spring-cloud-basic-samples/spring-cloud-basic-security)
  - [spring-cloud-basic-security-authorization-server](./spring-cloud-basic-samples/spring-cloud-basic-security/spring-cloud-basic-security-authorization-server): 认证、授权中心
     - 端口: 8766
```
// 暴露的端点(与令牌相关)
GET  /oauth/authorize  // => 
POST /oauth/authorize  // => 授权码类型和隐式类型的端点
GET  /oauth/token       // => 
POST /oauth/token       // => 获取令牌的端点
GET  /oauth/check_token  // => 检查令牌的有效性
GET  /oauth/error
```
  - [spring-cloud-basic-security-resource-server](./spring-cloud-basic-samples/spring-cloud-basic-security/spring-cloud-basic-security-resource-server): 资源中心
     - 端口: 8767
```
// 不用认证的地址
http://localhost:8767/instance/application  // => {"serviceId":"application","host":"localhost","port":8080}

// 需要认证的地址
http://localhost:8767/user/cangwu  // => <oauth><error_description>Full authentication is required to access this resource</error_description><error>unauthorized</error></oauth>

1）通过授权码类型获取访问令牌
http://localhost:8766/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://localhost:8888/
// => 自动跳转到 http://localhost:8766/login 进行登录，登录成功后跳转 => http://localhost:8888/?code=lYvkBi （其中lYvkBi即为授权码）

// 携带授权码访问/oauth/token获取到访问令牌
// POST请求
http://localhost:8766/oauth/token?grant_type=authorization_code&code=lYvkBi&redirect_uri=http://localhost:8888/login&client_id=client&client_secret=secret  // => {"access_token": "xxx", "refresh_token":"yyy"}

// 携带访问令牌再次访问/user/{userId}
http://localhost:8767/user/cangwu?access_token=xxx

2）通过密码类型获取访问令牌
http://localhost:8766/oauth/token?username=user_password&password=123456&grant_type=password&scope=all&client_id=client&client_secret=secret

// 之后同上
```
