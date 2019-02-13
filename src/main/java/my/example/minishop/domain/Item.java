package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
@Setter
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column
    private String name;
    @Column
    private Long price;
    @Column
    private int stock;
    @Column
    private Date regDate;
    @Lob
    private String description;
    @Column
    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Item(){
        regDate = new Date();
    }

}
