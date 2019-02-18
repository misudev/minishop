package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Category;
import my.example.minishop.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    @Transactional
    public List<Category> getCategoryAll(){
        return categoryRepository.getAll();
    }
    @Transactional
    public Category getCategoryById(Long id){
        return categoryRepository.getOne(id);
    }
}
