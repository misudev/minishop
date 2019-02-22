package my.example.minishop.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private String userName;
    private String addressZip;
    private String address;
    private String detailAddress;
    private String extraAddress;
    private String email;
    private String concat;
    private String memo;

    private List<Long> cartId;

}
