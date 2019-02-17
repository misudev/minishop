package my.example.minishop.repository;


import my.example.minishop.domain.Item;
import my.example.minishop.repository.custom.ItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {

}
