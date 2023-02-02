package com.jocata.tclutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jocata")
@EntityScan(basePackages = "com.jocata.tcldl.entity")
public class TclUtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TclUtilsApplication.class, args);
	}

}
