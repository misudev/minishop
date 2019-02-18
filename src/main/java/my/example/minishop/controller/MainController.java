package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Category;
import my.example.minishop.domain.Item;
import my.example.minishop.service.CategoryService;
import my.example.minishop.service.ItemService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class MainController {
    private final ItemService itemService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String start(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            @RequestParam(name = "searchKind", required = false) String searchKind,
            @RequestParam(name = "searchStr", required = false) String searchStr,
            Model model){

        List<Category> categories = categoryService.getCategoryAll();
        model.addAttribute("categories", categories);

        //수정 필요 **
        Category allCategory = new Category();
        allCategory.setId(0L);
        allCategory.setName("shop all");
        model.addAttribute("selectedCategory",
                categoryId !=null ? categoryService.getCategoryById(categoryId) :allCategory);

        List<Item> items = itemService.getItems(categoryId, page, searchKind, searchStr);
        model.addAttribute("items", items);
        return "index";
    }
//
//    @GetMapping("search")
//    public String search(@RequestParam(name = "searchStr") String searchStr,
//                         HttpServletRequest request){
//        request.setAttribute(searchStr+"");
//        return "/main?searchKind=NAME_OR_DESCRIPTION_SEARCH";
//    }


}
