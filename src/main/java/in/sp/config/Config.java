package in.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.sp.service.ServicesPro;
import in.sp.service.ServicesProImp;

@Configuration
@ComponentScan("in.sp")
public class Config {

	
	@Bean
	public DriverManagerDataSource data() {
		DriverManagerDataSource db= new DriverManagerDataSource();
		db.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		db.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		db.setUsername("springjdbc");
		db.setPassword("123");
		return db;
	}
	
	@Bean
	public JdbcTemplate curd() {
		JdbcTemplate temp = new JdbcTemplate();
		temp.setDataSource(data());
		return temp;
	}
}
