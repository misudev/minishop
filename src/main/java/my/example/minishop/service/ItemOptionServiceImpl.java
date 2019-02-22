//package my.example.minishop.service;
//
//import lombok.RequiredArgsConstructor;
//import my.example.minishop.domain.ItemOption;
//import my.example.minishop.repository.ItemOptionRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ItemOptionServiceImpl implements ItemOptionService {
//    private final ItemOptionRepository itemOptionRepository;
//
//    @Transactional
//    @Modifying
//    @Override
//    public ItemOption addItemOption(ItemOption itemOption) {
//        return itemOptionRepository.save(itemOption);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<ItemOption> getItemOptionsByItemId(Long itemId) {
//        return itemOptionRepository.getItemOptionsByItemId(itemId);
//    }
//
//    @Transactional
//    @Override
//    public void deleteItemOption(Long itemOptionId) {
//        itemOptionRepository.deleteById(itemOptionId);
//    }
//}
