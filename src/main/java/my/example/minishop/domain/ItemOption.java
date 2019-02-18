package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_option")
@Setter
@Getter
public class ItemOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column
    private String name;
    @Column
    private Long price;
}
