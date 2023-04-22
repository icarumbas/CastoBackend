package com.icarumbas.casto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.icarumbas.binance",
		"com.icarumbas.coingecko",
		"com.icarumbas.core",
})
public class CastoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastoBackendApplication.class, args);
	}
}
