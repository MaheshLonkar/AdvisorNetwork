package com.mahindrafin.advisornetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.mahindrafin.advisornetwork.repository.*") 
@ComponentScan(basePackages = { "com.*" }) 
@EntityScan("com.mahindrafin.advisornetwork.model.*")
@SpringBootApplication
public class AdvisorNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvisorNetworkApplication.class, args);
	}

}
