package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_detail")
@Setter
@Getter
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long cartId;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
