package cn.chenzw.spring.xml.schema;

import cn.chenzw.spring.xml.schema.domain.bean.CrmSSOTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:app-context.xml"})
public class SSONamespaceHandlerTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testSSOTemplateScan() {
        // 扫描并注入成功
        Assert.assertTrue(applicationContext.containsBean("cn.chenzw.spring.xml.schema.domain.bean.CrmSSOTemplate"));

        CrmSSOTemplate bean = applicationContext.getBean(CrmSSOTemplate.class);
        Assert.assertEquals(bean.validate(), false);
    }

}
