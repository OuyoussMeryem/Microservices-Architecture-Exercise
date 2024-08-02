package ma.ensa.customer_service;

import ma.ensa.customer_service.entities.Customer;
import ma.ensa.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("meryem").email("meryem@Gmail.com").build(),
					Customer.builder().name("ouyouss").email("ouyouss@Gmail.com").build(),
					Customer.builder().name("ensa").email("ensa@Gmail.com").build(),
					Customer.builder().name("ibrahim").email("ibrahim@Gmail.com").build()
			));

			customerRepository.findAll().forEach(System.out::println);
		};
	}
}