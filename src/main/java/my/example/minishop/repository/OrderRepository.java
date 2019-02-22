package my.example.minishop.repository;

import my.example.minishop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.userId =:userId")
    public List<Order> getOrdersByUserId (@Param("userId")Long userId);
}
