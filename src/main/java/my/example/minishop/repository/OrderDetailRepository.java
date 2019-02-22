package my.example.minishop.repository;

import my.example.minishop.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT o FROM OrderDetail o WHERE o.orderId =:orderId")
    public List<OrderDetail> getOrderDetailsByOrderId(@Param("orderId")Long orderId);
}
