package my.example.minishop.repository;

import my.example.minishop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);
}
