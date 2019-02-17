package my.example.minishop.service;

import my.example.minishop.domain.ImageFile;

import java.util.List;

public interface ImageFileService {
    public ImageFile addImageFile(ImageFile imageFile, Long itemId);
  // public ImageFile getImageFileByItem(Long itemId);
  //  public List<ImageFile> getImageFilesByItem(Long itemId);
    public ImageFile getImageFile(Long id);
}
