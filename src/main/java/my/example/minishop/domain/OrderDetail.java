package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@Setter
@Getter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column
    private Long itemId;
    @Column(name = "order_id")
    private Long orderId;
    @Column
    private Long itemPrice;
    @Column(length = 255)
    private String itemName;
    @Column
    private String itemPhoneType;
    @Column
    private int orderQuantity;


}
