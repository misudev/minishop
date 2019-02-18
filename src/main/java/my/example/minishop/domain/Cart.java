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

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    @Column
    private Long userId;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
