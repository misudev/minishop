package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Category;
import my.example.minishop.domain.ImageFile;
import my.example.minishop.domain.Item;
import my.example.minishop.service.CategoryService;
import my.example.minishop.service.ImageFileService;
import my.example.minishop.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ImageFileService imageFileService;
    private final ItemService itemService;
    private final CategoryService categoryService;

    @GetMapping("/images/{id}")
    @ResponseBody
    public void downloadImage(  //view를 리턴하는 것이 아니고 값을 직접 출력해준다.
            @PathVariable(name = "id") Long id,
            HttpServletResponse response
    ){
        ImageFile imageFile = imageFileService.getImageFile(id);
        response.setContentType(imageFile.getMimeType());

        try(FileInputStream fis = new FileInputStream(imageFile.getSaveFileName());
            OutputStream out = response.getOutputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;

            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer, 0, readCount);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @GetMapping("/{id}")
    public String itemDetail(@PathVariable(name = "id") Long id,
                           Model model
    ){

        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);

        List<Category> categories = categoryService.getCategoryAll();
        model.addAttribute("categories", categories);

        //수정 필요 **
        Category allCategory = new Category();
        allCategory.setId(0L);
        allCategory.setName("shop all");
        model.addAttribute("selectedCategory", allCategory);

        return "shop-single";
    }

}
