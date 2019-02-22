package my.example.minishop.domain;

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
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
    private String detailAddress;   //상세주소
    @Column
    private String extraAddress;    //참고항목
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

    public void addOrderDetail(OrderDetail orderDetail){
        if(orderDetailList==null)
            orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);
    }

}
