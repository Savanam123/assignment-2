package com.jocata.tclpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jocata")
@EntityScan(basePackages = "com.jocata.tcldl.entity")
public class TclPlAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TclPlAppApplication.class, args);
	}

}
