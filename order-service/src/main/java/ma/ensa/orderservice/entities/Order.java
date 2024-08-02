package ma.ensa.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ensa.orderservice.enums.OrderStatus;
import ma.ensa.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    public double getSomme(){
        double somme=0;
        for(ProductItem pi:productItems){
          somme+=pi.getAmount();
        }
        return somme;
    }
}
