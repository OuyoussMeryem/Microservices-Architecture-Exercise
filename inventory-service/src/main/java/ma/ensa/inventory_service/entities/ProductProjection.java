package ma.ensa.inventory_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullname",types = Product.class)
public interface ProductProjection {
    Long getId();
    String getName();
    double getPrice();
    int getQuantity();
}
