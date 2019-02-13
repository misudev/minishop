package my.example.minishop.security;

import lombok.Generated;
import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Role;
import my.example.minishop.domain.User;
import my.example.minishop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor // final 인 필드만 초기화하는 생성자가 자동으로 만들어진다. 생성자주입시 사용
public class ShopUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if(user == null)
            throw  new UsernameNotFoundException(email + "에 해당하는 사용자가 없습니다.");
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for(Role role : roles)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        ShopSecurityUser shopSecurityUser = new ShopSecurityUser(email, user.getPasswd(), authorities);
        shopSecurityUser.setId(user.getId());
        shopSecurityUser.setName(user.getName());
        shopSecurityUser.setNickName(user.getNickName());
        return shopSecurityUser;
    }

}
