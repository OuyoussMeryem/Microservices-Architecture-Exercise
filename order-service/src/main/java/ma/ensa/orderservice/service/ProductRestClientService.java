package ma.ensa.orderservice.service;

import ma.ensa.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="inventory-service")
public interface ProductRestClientService {

    @GetMapping("/products/{id}?projection=fullname")
    public Product productById(@PathVariable Long id);

    @GetMapping("/products?projection=fullname")
    public PagedModel<Product> products();
}
