package com.coll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.models.Blog;
import com.coll.models.BlogComment;
import com.coll.models.Forum;
import com.coll.models.Friend;
import com.coll.models.Job;
import com.coll.models.User;

@Configuration
@ComponentScan("com.coll")
@EnableTransactionManagement
public class DBConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
		dataSource.setUsername("System");
		dataSource.setPassword("password");
		System.out.println("-------------dataSource bean created----------");
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp = new Properties();

		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "create");
		hibernateProp.put("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(Friend.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);

		SessionFactory sessionFactory = sessionFactoryBuilder.buildSessionFactory();
		
		System.out.println("-------------sessionFactory bean created----------------------");
		return sessionFactory;

	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		System.out.println("---------------------Created the TranactionManager------------------");
		return new HibernateTransactionManager(sessionFactory);
	}
}
