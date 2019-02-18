package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.ImageFile;
import my.example.minishop.repository.ImageFileRepository;
import my.example.minishop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {
    private final ImageFileRepository imageFileRepository;
    private final ItemRepository itemRepository;
    @Override
    @Transactional
    public ImageFile addImageFile(ImageFile imageFile, Long itemId) {
        imageFile.setItem(itemRepository.getOne(itemId));
        return imageFileRepository.save(imageFile);
    }
/*
    @Override
    public ImageFile getImageFileByItem(Long itemId) {
        return imageFileRepository.getImageFileByItemId(itemId);
    }

    @Override
    public List<ImageFile> getImageFilesByItem(Long itemId){
        return imageFileRepository.getImageFilesByItemId(itemId);
    }*/

    @Override
    public ImageFile getImageFile(Long id) {
        return imageFileRepository.getOne(id);
    }
}
