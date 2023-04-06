package cn.chenzw.spring.mvc.datasource;

import cn.chenzw.spring.mvc.datasource.config.DataSourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
@WebAppConfiguration
public class DataSourceTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource(){
        Assert.assertNotNull(dataSource);
    }

}
