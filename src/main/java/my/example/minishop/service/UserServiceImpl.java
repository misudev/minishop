package my.example.minishop.service;

import my.example.minishop.domain.User;
import my.example.minishop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUserAll(){ return userRepository.findAll();    }


}
