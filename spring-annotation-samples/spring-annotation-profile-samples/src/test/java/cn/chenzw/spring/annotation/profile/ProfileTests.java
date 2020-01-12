package cn.chenzw.spring.annotation.profile;

import cn.chenzw.spring.annotation.profile.config.ProfileConfig;
import cn.chenzw.spring.annotation.profile.template.core.SSOTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles(value = "zj")
//@ActiveProfiles(value = "fj")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
public class ProfileTests {

    @Autowired
    SSOTemplate ssoTemplate;

    @Test
    public void testSSOTemplate(){
        // zj profile active
        // 等同于 -Dspring.profiles.active="zj"、spring.profiles.active=zj
        Assert.assertEquals(ssoTemplate.getName(), "浙江单点");
    }
}
