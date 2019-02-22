package my.example.minishop.controller;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.User;
import my.example.minishop.dto.JoinForm;
import my.example.minishop.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    //private final AccountService accountService;
    private final UserService userService;

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){

        return "users/login"; // view name 을 리턴한다.
    }

    @GetMapping("/join")
    public String join(){
        return "users/join";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if(!joinForm.getPassword1().equals(joinForm.getPassword2()))
            throw new IllegalArgumentException("암호와 암호확인이 틀려요.");


        User user = new User();
        user.setEmail(joinForm.getEmail());
        user.setName(joinForm.getName());
        user.setNickName(joinForm.getNickName());

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(joinForm.getPassword1()));

        User joinedUser = userService.join(user);

        return "redirect:/main";
    }


}