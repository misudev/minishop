package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.User;
import my.example.minishop.repository.RoleRepository;
import my.example.minishop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> getUserAll(){ return userRepository.findAll();    }

    @Override
    @Transactional
    public User join(User user) {
        user.addRole(roleRepository.getRoleByName("USER"));
        // 저장하고 저장된 객체 반환 ( id가 생성된 상태 )
        return userRepository.save(user);
    }
}
