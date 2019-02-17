package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    @JoinColumn(name ="item_option")
    private List<ItemOption> itemOptions;

    @OneToMany(mappedBy = "item",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImageFile> imageFiles;

    public Item(){
        regDate = new Date();
        itemOptions = new ArrayList<>();
    }

    public void addImageFile(ImageFile imageFile) {
        if(imageFiles == null)
            imageFiles = new ArrayList<>();
        imageFile.setItem(this); // 쌍방향이기 때문에 this를 참조하도록 한다.
        imageFiles.add(imageFile);
    }

}
