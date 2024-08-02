package ma.ensa.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="fullname",types = Customer.class)
public interface CustomerProjection {
    Long getId();
    String getName();
    String getEmail();
}
