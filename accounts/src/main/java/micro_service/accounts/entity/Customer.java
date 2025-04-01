package micro_service.accounts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @Column(name="customer_id")
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
}
