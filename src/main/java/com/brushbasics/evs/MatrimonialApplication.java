package com.brushbasics.evs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories
public class MatrimonialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatrimonialApplication.class, args);
	}

}
