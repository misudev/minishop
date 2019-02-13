package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column
    private Long userId;
    @Column
    private String status;
    // 배송지 정보
    @Column
    private String userName;
    @Column
    private String addressZip;
    @Column
    private String address;
    @Column
    private String contact;
    @Column
    private String memo;
    // 주문 정보
    @Column
    private String paymentType;
    @Column
    private Date regDate;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderDetail> orderDetailList;

    public Order(){
        regDate = new Date();
        orderDetailList = new ArrayList<>();
    }

}
