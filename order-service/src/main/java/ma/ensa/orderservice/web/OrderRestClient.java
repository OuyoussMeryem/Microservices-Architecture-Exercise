package ma.ensa.orderservice.web;

import ma.ensa.orderservice.entities.Order;
import ma.ensa.orderservice.model.Customer;
import ma.ensa.orderservice.model.Product;
import ma.ensa.orderservice.repositories.OrderRepository;
import ma.ensa.orderservice.repositories.ProductItemRepository;
import ma.ensa.orderservice.service.CustomerRestClientService;
import ma.ensa.orderservice.service.ProductRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestClient {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private ProductRestClientService productRestClientService;

    public OrderRestClient(OrderRepository orderRepository,
                           ProductItemRepository productItemRepository,
                           CustomerRestClientService customerRestClientService,
                           ProductRestClientService productRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.productRestClientService = productRestClientService;
    }
    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);

        order.getProductItems().forEach(pi->{
            Product product=productRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
                }

        );

        return order;

    }
}
