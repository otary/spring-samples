package cn.chenzw.springboot.mybatis.xml.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.scripting.xmltags.TextSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicSqlSourceTests {

    @Test
    public void test() throws SQLException {
        String sql = "select * from sys_user where username = #{userName}";
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("userName", "admin");
            }
        };

        // 生成数据源
        Properties properties = new Properties();
        properties.setProperty("driver", "org.h2.Driver");
        properties.setProperty("url", "jdbc:h2:mem:test");
        properties.setProperty("username", "sa");
        properties.setProperty("password", "");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();

        // 生成配置
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",
                transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        // 绑定参数
        TextSqlNode node = new TextSqlNode(sql);
        DynamicSqlSource dynamicSqlSource = new DynamicSqlSource(
                configuration,
                node
        );
        BoundSql boundSql = dynamicSqlSource.getBoundSql(params);
        String resultSql = boundSql.getSql();

        log.info("生成SQL => {}", resultSql);  // => select * from sys_user where user_name = ?

        Connection connection = dataSource.getConnection();
        SqlRunner sqlRunner = new SqlRunner(connection);
        List<Map<String, Object>> rsList = sqlRunner.selectAll(resultSql, new Object[]{
                "admin"
        });

        log.info("查询结果 => {}", rsList);

    }
}
