package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;

    @OneToMany
    @JoinColumn(name = "cart_id")
    private List<OrderDetail> cartDetailList;

    public Cart(){
        cartDetailList = new ArrayList<>();
    }
}
