package caixa.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cache.annotation.EnableCaching;

@Configuration
@SpringBootApplication
public class CaixaTechnicalSolutionApplication{

	public static void main(String[] args) {
	    SpringApplication.run(CaixaTechnicalSolutionApplication.class, args);
	}

}
