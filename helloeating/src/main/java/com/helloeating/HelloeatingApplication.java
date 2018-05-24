package com.helloeating;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloeatingApplication {

	//log4j 
	private static final Logger logger = LogManager.getLogger(HelloeatingApplication.class);
	
	public static void main(String[] args) {
		logger.info("Starting Spring Boot application... Helloeating");
		SpringApplication.run(HelloeatingApplication.class, args);
	}
	
	/*
     * SqlSessionFactory 설정 
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
    	
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
        
    }
}
