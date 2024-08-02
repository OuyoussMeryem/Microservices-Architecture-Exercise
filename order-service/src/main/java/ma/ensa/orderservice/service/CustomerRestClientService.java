package ma.ensa.orderservice.service;

import ma.ensa.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service")
public interface CustomerRestClientService {
    @GetMapping("/customers/{id}?projection=fullname")
    public Customer customerById(@PathVariable Long id);

    @GetMapping("/customers?projection=fullname")
    public PagedModel<Customer> customers();
}
