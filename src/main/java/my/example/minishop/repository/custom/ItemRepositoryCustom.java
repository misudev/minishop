package my.example.minishop.repository.custom;

import my.example.minishop.domain.Item;

import java.util.List;

public interface ItemRepositoryCustom {
    public List<Item> getItems(Long categoryId, int start, int limit, String searchKind, String searchStr);
    public Long getItemsCount(Long categoryId, String searchKind, String searchStr);
}
