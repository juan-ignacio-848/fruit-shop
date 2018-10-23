package com.nmkip.fruitshop.mapper;

import com.nmkip.fruitshop.domain.Category;
import com.nmkip.fruitshop.dto.CategoryDTO;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CategoryConverterTest {

    @Test
    public void categoryToCategoryDTO() {
        Category category = new Category("Fruits");
        CategoryConverter categoryConverter = new CategoryConverter();

        final CategoryDTO categoryDTO = categoryConverter.convert(category);
        assertThat(categoryDTO.getName()).isEqualTo("Fruits");
        assertThat(categoryDTO.getCategoryUrl()).isEqualTo("/shop/categories/Fruits");
    }
}
