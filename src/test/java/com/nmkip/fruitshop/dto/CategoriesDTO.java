package com.nmkip.fruitshop.dto;

import java.util.List;

public class CategoriesDTO {

    private List<CategoryDTO> categories;

    public CategoriesDTO() {
    }

    public CategoriesDTO(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
