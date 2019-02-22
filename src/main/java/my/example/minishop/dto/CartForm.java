package my.example.minishop.dto;

import lombok.Data;

@Data
public class CartForm {
    private Long itemId;
    private String phoneType;
    private int quantity;
}
