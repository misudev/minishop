package my.example.minishop.service;

import my.example.minishop.domain.Item;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item, Long categoryId);
    public Item getItemById(Long id);
    public List<Item> getItems(Long categoryId, int page, String searchKind, String searchStr);
}
