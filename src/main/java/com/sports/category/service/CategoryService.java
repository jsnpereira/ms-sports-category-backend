package com.sports.category.service;

import com.sports.category.dto.mapper.CategoryMapper;
import com.sports.category.dto.request.CategoryDTO;
import com.sports.category.entity.Category;
import com.sports.category.exception.CategoryNotFoundException;
import com.sports.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategoryListByEventId(String eventId) {
       List<Category> categories = categoryRepository.findByEventId(eventId);
       return categories.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteCategory(String categoryId) throws CategoryNotFoundException {
        Optional<Category> category = getCategoryById(categoryId);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
        }
    }

    public Optional<Category> getCategoryById(String id) throws CategoryNotFoundException {
        return Optional.ofNullable(categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id)));
    }

    public void createCategories(List<CategoryDTO> categories){
        List<Category> list = categories.stream().map(CategoryMapper::toModel).collect(Collectors.toList());
        System.out.println(list);
        categoryRepository.saveAll(list);
    }
}
