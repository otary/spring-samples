package cn.chenzw.spring.annotation.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder().setName("dev-db")
                .setType(EmbeddedDatabaseType.H2)
                //.addScript("classpath:schema.sql")
                //.addScript("classpath:dev-data.sql")
                .build();
    }

    @Bean
    @Profile("prod")
    public DataSource embeddedDataSourceDev() {
        return new EmbeddedDatabaseBuilder().setName("prod-db")
                .setType(EmbeddedDatabaseType.DERBY)
               // .addScript("classpath:schema.sql")
               // .addScript("classpath:prod-data.sql")
                .build();
    }
}
