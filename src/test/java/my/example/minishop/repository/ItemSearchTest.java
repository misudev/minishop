package my.example.minishop;

import my.example.minishop.domain.Item;
import my.example.minishop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemSearchTest {
    @Test
    public void searchTest(){
        ItemRepository itemRepository;
        List<Item> items = itemRepository.getItems(1, 0, 5, null, null);

        for(Item i : items)
            System.out.println(i.getCategory().getName()+"| 상품명 : "+i.getName()+" | 가격 : "+i.getPrice());
    }
}
