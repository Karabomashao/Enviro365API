package com.enviro.assessment.grad001.KaraboMashao.controller;


import com.enviro.assessment.grad001.KaraboMashao.model.Category;
import com.enviro.assessment.grad001.KaraboMashao.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategoryById(@PathVariable int id, @RequestBody Category category){
        return categoryService.updateCategoryById(id, category);
    }

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable int id){
        return categoryService.findCategoryById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCategoryById(@PathVariable int id){
        categoryService.deleteCategoryById(id);
    }

    @DeleteMapping()
    public void deleteAllCategories(){
        categoryService.deleteAllCategories();
    }

}
