package com.example.finalspring.MyConfig;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.finalspring")
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class SpringConfig {


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/variant2_Akimbayev");
			dataSource.setUsername("postgres");
			dataSource.setPassword("admin");

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactory =  new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.example.finalspring.entity");
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect"
				,"org.hibernate.dialect.PostgreSQL81Dialect");
		hibernateProperties.setProperty("hibernate.show_sql"
				,"true");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
}
