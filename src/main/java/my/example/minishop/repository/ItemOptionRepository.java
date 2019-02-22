//package my.example.minishop.repository;
//
//import my.example.minishop.domain.ItemOption;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
//    @Query("SELECT i FROM ItemOption i WHERE i.item.id = :itemId ORDER BY i.name")
//    public List<ItemOption> getItemOptionsByItemId(@Param("itemId")Long itemId);
//}
