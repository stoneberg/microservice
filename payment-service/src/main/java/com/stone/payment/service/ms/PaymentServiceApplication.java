package com.stone.payment.service.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.integralblue.log4jdbc.spring.Log4jdbcAutoConfiguration;

@SpringBootApplication(exclude = {
        Log4jdbcAutoConfiguration.class
})
@EnableEurekaClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
