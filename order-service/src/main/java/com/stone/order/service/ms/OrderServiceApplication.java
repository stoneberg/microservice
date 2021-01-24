package com.stone.order.service.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.integralblue.log4jdbc.spring.Log4jdbcAutoConfiguration;

@SpringBootApplication(exclude = {
        Log4jdbcAutoConfiguration.class
})
@EnableEurekaClient
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
