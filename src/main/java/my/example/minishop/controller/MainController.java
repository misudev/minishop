package my.example.minishop.controller;

import my.example.minishop.domain.User;
import my.example.minishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class MainController {
    @Autowired
    UserService userService;

//    @GetMapping("/")
//    public String start(){
//        return "/main";
//    }

    @GetMapping("/main")
    public String main(Model model){
        List<User> list = userService.getUserAll();
        model.addAttribute("list", list);
        return "index";
    }
}
