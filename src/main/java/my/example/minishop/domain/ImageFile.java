package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "image_file")
@Setter
@Getter
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 255)
    private String name; // 오리지널 파일 명. toto.png
    private long length;
    @Column(length = 255)
    private String saveFileName; //   /tmp/2019/02/01/1234-12342134-1234
    @Column(length = 255)
    private String mimeType;
    @Column
    private int ordering;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
