package my.example.minishop.repository;

import my.example.minishop.domain.Item;
import my.example.minishop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemSearchTest {
    @Autowired
    ItemRepository itemRepository;
    @Test
    public void searchTest(){
        List<Item> items = itemRepository.getItems(1L, 0, 5, null, null);
        List<Item> items2 = itemRepository.getItems(null, 0, 5, "NAME_SEARCH", "keyboard");

        for(Item i : items2)
            System.out.println("카테고리 : "+i.getCategory().getName()+" | 상품명 : "+i.getName()+" | 가격 : "+i.getPrice());

        System.out.println("폰케이스 카테고리 총 갯수 : "+itemRepository.getItemsCount(1L, null, null));
    }
}
