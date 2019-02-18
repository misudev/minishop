package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Category;
import my.example.minishop.domain.ImageFile;
import my.example.minishop.domain.Item;
import my.example.minishop.service.CategoryService;
import my.example.minishop.service.ItemService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    @GetMapping("")
    public String start(){
        return "admin/main";
    }

    @GetMapping("/regist")
    public String regist(Model model){
        List<Category> categories = categoryService.getCategoryAll();
        model.addAttribute("categories", categories);
        return "admin/regist";
    }

    @PostMapping("/regist")
    public String regist(@RequestParam(name = "name") String name,
                         @RequestParam(name = "price") String price,
                         @RequestParam(name = "stock") int stock,
                         @RequestParam(name = "categoryId") Long categoryId,
                         @RequestParam(name = "description") String description,
                         @RequestParam(name = "image") MultipartFile[] images){

        System.out.println("상품 등록------------------");
        Assert.hasText(name, "제품명을 입력하세요.");
        Assert.notNull(price, "가격을 입력하세요");
        Assert.notNull(stock, "재고을 입력하세요");

        Item newItem = new Item();
        newItem.setName(name);
        newItem.setPrice(Long.parseLong(price));
        newItem.setStock(stock);

        newItem.setDescription(description.replace("\r\n", "<br>"));

        if(images != null && images.length > 0) {
            int ordering = 1;
            for (MultipartFile image : images) {
                //if(image == null || image.getSize()==0) // 파일 있을때만 저장 **
                if(image.isEmpty())
                    continue;
                ImageFile imageFile = new ImageFile();
                imageFile.setLength(image.getSize());
                imageFile.setMimeType(image.getContentType());
                imageFile.setName(image.getOriginalFilename());
                imageFile.setOrdering(ordering++);
                // 파일 저장
                // /tmp/2019/2/12/123421-12341234-12341234-123423142
                String saveFileName = saveFile(image);

                imageFile.setSaveFileName(saveFileName); // save되는 파일명
                newItem.addImageFile(imageFile);
            }
        }


        itemService.addItem(newItem, categoryId);

        return "redirect:/main";
    }

    private String saveFile(MultipartFile image) {
        String dir = "/tmp/";
       // String dir = "/Users/jungmisu/IdeaProjects/minishop/src/imagefile/";
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.MONTH) + 1); // MONTH는 0부터 시작.
        dir = dir + "/";
        dir = dir + calendar.get(Calendar.DAY_OF_MONTH);
        File dirFile = new File(dir);
        dirFile.mkdirs(); // 디렉토리가 없을 경우 만든다.
                         // 퍼미션이 없으면 생성되지 않을 수 있다.
        dir = dir + "/" + UUID.randomUUID().toString();
        System.out.println("dir = "+dir);
        try(FileOutputStream fos = new FileOutputStream(dir);
            InputStream in = image.getInputStream()
        ){
          byte[] buffer = new byte[1024];
          int readCount = 0;
          while((readCount = in.read(buffer)) != -1){
              fos.write(buffer,0,readCount);
          }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return dir;

    }

}
