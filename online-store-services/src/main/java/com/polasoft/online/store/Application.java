package com.polasoft.online.store;

import com.polasoft.online.store.model.entity.Product;
import com.polasoft.online.store.model.repository.ProductRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
        
        @Bean
	public CommandLineRunner demo(ProductRepository repo) {
            return (args) -> {
                Product p = new Product();
                p.setBrand("Test");
                p.setName("test name");
                p.setEspecification("test this");
                p.setDirections("test this");
                p.setIngredients("test, test, test");
                p.setPrice(BigDecimal.TEN);
                
                repo.save(p);
            };
        }
}
