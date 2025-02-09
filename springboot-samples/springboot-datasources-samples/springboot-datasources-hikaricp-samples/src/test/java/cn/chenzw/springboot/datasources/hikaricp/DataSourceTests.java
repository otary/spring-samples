package cn.chenzw.springboot.datasources.hikaricp;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTests {

    @Autowired
    private HikariDataSource dataSource;

    @Test
    public void test() throws SQLException {
        HikariConfig configuration = new HikariConfig();

        HikariDataSource hikariDataSource = new HikariDataSource(configuration);

        hikariDataSource.getConnection();
    }

    @Test
    public void testDataSource() throws SQLException {
        log.info("dataSource: {}", dataSource);
    }
}
