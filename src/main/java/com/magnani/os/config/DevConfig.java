package com.magnani.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.magnani.os.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String dll;

	@Bean
	public boolean instaciaDB() {
		
		if(dll.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;

	}

}
