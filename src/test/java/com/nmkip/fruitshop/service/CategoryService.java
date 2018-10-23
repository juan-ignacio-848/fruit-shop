package com.nmkip.fruitshop.service;

import com.nmkip.fruitshop.domain.Category;
import com.nmkip.fruitshop.dto.CategoryDTO;
import com.nmkip.fruitshop.exception.CategoryNotFoundException;
import com.nmkip.fruitshop.mapper.CategoryConverter;
import com.nmkip.fruitshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryConverter categoryConverter;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryConverter categoryConverter, CategoryRepository categoryRepository) {
        this.categoryConverter = categoryConverter;
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryDTO> findAll() {

        final List<Category> allCategories = categoryRepository.findAll();

        if(allCategories == null) {
            throw new CategoryNotFoundException();
        }

        return allCategories
                .stream()
                .map(categoryConverter::convert)
                .collect(Collectors.toList());
    }
}
