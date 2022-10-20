package com.sports.category.dto.mapper;

import com.sports.category.dto.request.CategoryDTO;
import com.sports.category.entity.Category;

public class CategoryMapper {

    public static Category toModel(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setTitle(categoryDTO.getTitle());
        category.setDescription(categoryDTO.getDescription());
        category.setEventId(categoryDTO.getEventId());
        return category;
    }

    public static CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setTitle(category.getTitle());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setEventId(category.getEventId());
        return categoryDTO;
    }
}
