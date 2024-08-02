package ma.ensa.orderservice.entities;

import ma.ensa.orderservice.enums.OrderStatus;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="fullOrder",types=Order.class)
public interface OrderProjection {
    public Long getId();
    public Date getCreatedAt();
    public OrderStatus getStatus();
    public Long getCustomerId();
}
