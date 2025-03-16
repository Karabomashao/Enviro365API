package com.example.enviro365_.service;

import com.example.enviro365_.model.Category;
import com.example.enviro365_.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(() -> new NullPointerException("Id not found"));
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategoryById(int id, Category category){
        Category existingCategory = findCategoryById(id);
        existingCategory.setDescription(category.getDescription());
        existingCategory.setTypeOfCategory(category.getTypeOfCategory());
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }

    public void deleteAllCategories(){
        categoryRepository.deleteAll();
    }
}
