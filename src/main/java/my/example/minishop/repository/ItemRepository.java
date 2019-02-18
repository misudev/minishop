package my.example.minishop.repository;


import my.example.minishop.domain.Item;
import my.example.minishop.repository.custom.ItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
    @Query("SELECT distinct i FROM Item i INNER JOIN FETCH i.category  LEFT JOIN FETCH i.imageFiles WHERE i.id = :id")
    public Item getItem(@Param("id") Long id);
}
