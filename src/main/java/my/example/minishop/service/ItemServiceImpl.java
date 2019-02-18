package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Category;
import my.example.minishop.domain.Item;
import my.example.minishop.repository.CategoryRepository;
import my.example.minishop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{
     final private ItemRepository itemRepository;
     final private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Item addItem(Item item, Long categoryId) {
        Optional<Category> optionalCategory
                = categoryRepository.findById(categoryId);
        item.setCategory(optionalCategory.get());
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.getItem(id);
    }

    @Transactional(readOnly = true)
    public List<Item> getItems(Long categoryId, int page, String searchKind, String searchStr){
        int limit = 6;
        int start = page * limit - limit;
        return itemRepository.getItems(categoryId, start, limit, searchKind, searchStr);
    }

}
