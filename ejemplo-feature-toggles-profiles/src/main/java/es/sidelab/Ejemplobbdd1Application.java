package es.sidelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Ejemplobbdd1Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Ejemplobbdd1Application.class, args);
    }
    
}
