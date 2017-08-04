package com.perqin.focus.spring.config;

import com.mysql.jdbc.Driver;
import com.perqin.focus.spring.domain.entities.EntityScanned;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.perqin.focus.spring.domain.repositories")
@EnableTransactionManagement
public class PersistenceJpaConfig {
    @Bean
    public DataSource dataSource() {
//        dataSource.setDriverClassName(Driver.class.getName());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername("perqin");
        dataSource.setPassword("dev123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/focus_spring?useUnicode=true&characterEncoding=UTF-8");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(EntityScanned.class.getPackage().toString());
        factory.setDataSource(dataSource());
        factory.setJpaProperties(jpaProperties());

        return factory;
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");  // MySQL5InnoDBDialect   MySQLMyISAMDialect
        properties.put("hibernate.show_sql", "true");
        return properties;
    }
}
