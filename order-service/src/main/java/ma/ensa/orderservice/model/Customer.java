package ma.ensa.orderservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private Long id;
    private String name;
    private String email;
}
