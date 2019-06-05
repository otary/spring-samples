# spring-samples


- **[spring-xml-schema-samples](spring-xml-samples/spring-xml-schema-samples)**: 自定义标签示例


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