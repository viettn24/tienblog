package com.tien.blog.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.tien.blog")
@PropertySource({"classpath:persistence-mysql.properties", "classpath:security-persistence-mysql.properties"})
public class AppConfig{
	
	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		
		return viewResolver;
	}
	
	@Bean
	public DataSource theDataSource() {
		
		ComboPooledDataSource theDataSource = new ComboPooledDataSource();
		
		try {
			theDataSource.setDriverClass(env.getProperty("jdbc.Driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
			theDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			theDataSource.setUser(env.getProperty("jdbc.user"));
			theDataSource.setPassword(env.getProperty("jdbc.pass"));
		
			
			theDataSource.setInitialPoolSize(convertInt("connection.pool.initalPoolSize"));
			theDataSource.setMinPoolSize(convertInt("connection.pool.minPoolSize"));
			theDataSource.setMaxPoolSize(convertInt("connection.pool.maxPoolSize"));
			theDataSource.setMaxIdleTime(convertInt("connection.pool.maxIdleTime"));
			
			
		
		return theDataSource;
	}
	
	
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource securityDataSource
									= new ComboPooledDataSource();
				
		// set the jdbc driver class
		
		try {
			securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection props
		// for sanity's sake, log this info
		// just to make sure we are REALLY reading data from properties file
		
		
		// set database connection props
		
		securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
		securityDataSource.setUser(env.getProperty("security.jdbc.user"));
		securityDataSource.setPassword(env.getProperty("security.jdbc.password"));
		
		// set connection pool props
		
		securityDataSource.setInitialPoolSize(
				convertInt("security.connection.pool.initialPoolSize"));

		securityDataSource.setMinPoolSize(
				convertInt("security.connection.pool.minPoolSize"));

		securityDataSource.setMaxPoolSize(
				convertInt("security.connection.pool.maxPoolSize"));

		securityDataSource.setMaxIdleTime(
				convertInt("security.connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	
	public int convertInt(String poolProperty) {
		String envPro = env.getProperty(poolProperty);
		
		int envInt = Integer.parseInt(envPro);		
		
		return envInt;
	}
	
	
	
	//Hibernate Config........
	
	private Properties getHibernateProperties() {
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(theDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txtManager = new HibernateTransactionManager();
		txtManager.setSessionFactory(sessionFactory);
		
		return txtManager;
	}
	
	
	
	
	
	
	
	
	
}










