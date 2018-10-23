package com.nmkip.fruitshop.mapper;

import com.nmkip.fruitshop.domain.Category;
import com.nmkip.fruitshop.dto.CategoryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Category, CategoryDTO> {

    @Override
    public CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setCategoryUrl("/shop/categories/" + category.getName());
        return categoryDTO;
    }
}
