package my.example.minishop.repository;

import my.example.minishop.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
    // 처음 이미지 하나만 가져오기.
    @Query("SELECT i FROM ImageFile i WHERE i.item.id = :itemId AND i.ordering = 1")
    public ImageFile getImageFileByItemId(@Param("itemId")Long itemId);
    // 이미지 리스트 가져오기
    @Query("SELECT i FROM ImageFile i WHERE i.item.id = :itemId")
    public List<ImageFile> getImageFilesByItemId(@Param("itemId")Long itemId);
}
