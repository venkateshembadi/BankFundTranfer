package com.training.fund.fundtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.training.fund.fundtransfer.repository"})
@ComponentScan(basePackages= {"com.training.fund.fundtransfer.entity","com.training.fund.fundtransfer.service","com.training.fund.fundtransfer.config","com.training.fund.fundtransfer.controller"})
public class FundtransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundtransferApplication.class, args);
	}

}
