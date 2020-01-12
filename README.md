# spring-samples


![spring](https://img.shields.io/badge/spring-4.3.24.RELEASE-green.svg)
![jdk](https://img.shields.io/badge/jdk-1.8-green.svg)

- [spring-xml-samples](spring-xml-samples)
  - [spring-xml-schema-samples](spring-xml-samples/spring-xml-schema-samples): 自定义标签示例

- [spring-annotation-samples](spring-annotation-samples): JavaConfig配置方式
  - [spring-annotation-aware-samples](spring-annotation-samples/spring-annotation-aware-samples): aware示例
  - [spring-annotation-el-samples](spring-annotation-samples/spring-annotation-el-samples)
  - [spring-annotation-profile-samples](spring-annotation-samples/spring-annotation-profile-samples): profile示例

- [spring-tomcat-samples](spring-tomcat-samples)


---
## spring-xml-schema-samples

自定义标签示例

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:sso="http://www.chenzw.cn/schema/sso"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.chenzw.cn/schema/sso http://www.chenzw.cn/schema/sso.xsd">

    <!-- 自定义扫描器 -->
    <sso:template-scan base-package="cn.chenzw.springmvc.xml.schema"/>
</beans>
```