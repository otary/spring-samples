package cn.chenzw.spring.annotation.profile;

import cn.chenzw.spring.annotation.profile.config.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class DataSourceProfileTests {

    @Test
    public void testDataSource() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 使用Derby数据源
        applicationContext.getEnvironment().setActiveProfiles("prod");
        applicationContext.register(DataSourceConfig.class);
        applicationContext.refresh();

        DataSource dataSource = applicationContext.getBean(DataSource.class);

    }
}
