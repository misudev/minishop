//package my.example.minishop.controller.api;
//
//import lombok.RequiredArgsConstructor;
//import my.example.minishop.domain.Item;
//import my.example.minishop.domain.ItemOption;
//import my.example.minishop.domain.PhoneType;
//import my.example.minishop.service.ItemOptionService;
//import my.example.minishop.service.ItemService;
//import my.example.minishop.service.PhoneTypeService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin")
//@RequiredArgsConstructor
//public class AdminApiController {
//    private final ItemOptionService itemOptionService;
//    private final PhoneTypeService phoneTypeService;
//    private final ItemService itemService;
//    @PostMapping
//    public String addOption(@RequestParam(name="phoneTypeId")Long phoneTypeId,
//                            @RequestParam(name = "itemId")Long itemId){
//        PhoneType phoneType = phoneTypeService.getById(phoneTypeId);
//        Item item = itemService.getItemById(itemId);
//        ItemOption itemOption = new ItemOption();
//        itemOption.setName(phoneType.getName());
//        itemOption.setItem(item);
//        item.addItemOption(itemOptionService.addItemOption(itemOption));
//        return phoneType.getName();
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCart(@PathVariable(name = "id") Long optionId){
//        itemOptionService.deleteItemOption(optionId);
//        return "true";
//    }
//}
