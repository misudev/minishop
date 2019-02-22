package my.example.minishop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phone_type")
@Getter
@Setter
public class PhoneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column
    private String name;
}
