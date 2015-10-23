package com.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Class {@link com.ecommerce.config.ApplicationConfig}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 12.10.15
 */
@Configuration
public class ApplicationConfig{
    private static final Integer TASKS_POOL_SIZE = 10;

    @Value("${PORT:8080}")
    private int port;

    @Value("${MYSQL_URL}")
    private String url;

    @Value("${MYSQL_USERNAME}")
    private String username;

    @Value("${MYSQL_PASSWORD}")
    private String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(destroyMethod = "shutdown")
    public ScheduledExecutorService taskExecutor() {
        return Executors.newScheduledThreadPool(TASKS_POOL_SIZE);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        JettyEmbeddedServletContainerFactory servletContainer =
                new JettyEmbeddedServletContainerFactory("/*", port);
        return servletContainer;
    }

    @Bean
    public DataSource makeDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
