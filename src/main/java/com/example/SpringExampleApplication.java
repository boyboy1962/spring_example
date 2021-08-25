package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//@ComponentScan(basePackages={"com", "com.example", "com.marobiana"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // 이게 데이타 소스는 보지 않게다 해서 DB는 찾지 않는다.
@MapperScan(basePackages = "com.example.*") // mapper scan 추가!!! DB위함이다.
@SpringBootApplication
// @ComponentScan(basePackages = "com.marobiana") // com.marobia 모든 Bean을 사용한다.(404 에러가 생긴 이유) 바보야...
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	@Bean //객채이다. 보통은 설정 파일로 동작하는 객채... 설정
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		//Mapper의 Table 단위로 써야한다.
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); // 약속된 경로이기에 무족건 이렇게 써야한다.
		sessionFactory.setMapperLocations(res);

		return sessionFactory.getObject();
	}

}
