package my.example.minishop.repository;

import my.example.minishop.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT c FROM Cart c WHERE c.userId = :userId")
    public List<Cart> getCartByUser(@Param("userId")Long userId);

    @Query("SELECT c FROM Cart c WHERE c.userId = :userId AND c.item.id = :itemId AND c.phoneType =:phoneType")
    public Cart getCartByUserAndItemAndPhoneType(@Param("userId")Long userId,
                                     @Param("itemId")Long itemId,@Param("phoneType")String phoneType);

    @Modifying
    @Query("UPDATE Cart c SET c.quantity = :quantity WHERE c.id = :id")
    public void updateCart(@Param("quantity")int quantity,
                           @Param("id")Long id);

    @Query("SELECT c FROM Cart c INNER JOIN FETCH c.item WHERE c.id =:cartId")
    public Cart getCartById(@Param("cartId") Long cartId);
}
