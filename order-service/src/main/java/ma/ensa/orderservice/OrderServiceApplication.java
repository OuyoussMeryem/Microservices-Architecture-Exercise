package ma.ensa.orderservice;

import ma.ensa.orderservice.entities.Order;
import ma.ensa.orderservice.entities.ProductItem;
import ma.ensa.orderservice.enums.OrderStatus;
import ma.ensa.orderservice.model.Customer;
import ma.ensa.orderservice.model.Product;
import ma.ensa.orderservice.repositories.OrderRepository;
import ma.ensa.orderservice.repositories.ProductItemRepository;
import ma.ensa.orderservice.service.CustomerRestClientService;
import ma.ensa.orderservice.service.ProductRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrderRepository orderRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClientService customerRestClientService,
										ProductRestClientService productRestClientService){
		return args -> {
			List<Customer> customers=customerRestClientService.customers().getContent().stream().toList();
			List<Product> products=productRestClientService.products().getContent().stream().toList();
			Random random=new Random();
			for (int i = 0; i < 20; i++) {
				Order order=Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random()>0.5? OrderStatus.CREATED:OrderStatus.PENDING)
						.createdAt(new Date())
						.build();

				Order savedOrder=orderRepository.save(order);
				for (int j = 0; j < products.size(); j++) {
					if(Math.random()>0.70){
						ProductItem  productItem=ProductItem.builder()
								.order(savedOrder)
								.productId(products.get(j).getId())
								.price(products.get(j).getPrice())
								.quantity(products.get(j).getQuantity())
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);

					}

				}

			}

		};
	}

}
