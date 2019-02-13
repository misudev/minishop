package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity // 영속성객체
@Table(name = "user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String passwd;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "nick_name", length = 20)
    private String nickName;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;


    public User(){
        createDate = new Date();
        roles = new HashSet<>();
    }
}
