package my.example.minishop.dto;

import lombok.Data;

@Data
public class CartDto {
    private Long cartId;
    private int quantity;
}
