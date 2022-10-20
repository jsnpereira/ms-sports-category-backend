package com.sports.category.controller;

import com.sports.category.dto.request.CategoryDTO;
import com.sports.category.entity.Category;
import com.sports.category.exception.CategoryNotFoundException;
import com.sports.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sports/v1/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategories(@RequestParam(required = false) String event) {
        List<CategoryDTO> categories;
        if (event == null || event.isEmpty()) {
            categories = categoryService.getAllCategory();
        } else {
            categories = categoryService.getCategoryListByEventId(event);
        }
        return categories;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable(name = "id") String categoryId) throws CategoryNotFoundException {
        categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Category> getCategoriesById(@PathVariable(name = "id") String categoryId) throws CategoryNotFoundException {
        Optional<Category> categories;
        categories = categoryService.getCategoryById(categoryId);
        return categories;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postCategories(@RequestBody @Valid List<CategoryDTO> categories) {
        categoryService.createCategories(categories);
    }
}
