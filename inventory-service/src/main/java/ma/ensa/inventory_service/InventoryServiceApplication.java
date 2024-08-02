package ma.ensa.inventory_service;

import ma.ensa.inventory_service.entities.Product;
import ma.ensa.inventory_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder().name("Computer").price(1200).quantity(10).build(),
					Product.builder().name("Phone").price(1908).quantity(16).build(),
					Product.builder().name("Television").price(5400).quantity(76).build(),
					Product.builder().name("Computer hp").price(1200).quantity(10).build(),
					Product.builder().name("Phone hp").price(1908).quantity(16).build(),
					Product.builder().name("Television hp").price(5400).quantity(76).build(),
					Product.builder().name("Computer accer").price(1200).quantity(10).build(),
					Product.builder().name("Phone iphone").price(1908).quantity(16).build(),
					Product.builder().name("Television sumsung").price(5400).quantity(76).build()
			));

			productRepository.findAll().forEach(System.out::println);
		};
	}
}
