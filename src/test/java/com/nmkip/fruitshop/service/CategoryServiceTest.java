package com.nmkip.fruitshop.service;

import com.nmkip.fruitshop.domain.Category;
import com.nmkip.fruitshop.dto.CategoryDTO;
import com.nmkip.fruitshop.exception.CategoryNotFoundException;
import com.nmkip.fruitshop.mapper.CategoryConverter;
import com.nmkip.fruitshop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        categoryService = new CategoryService(new CategoryConverter(), categoryRepository);
    }

    @Test
    public void findAll_returnsCategories() {
        given(categoryRepository.findAll()).willReturn(
                Arrays.asList(
                        new Category("Fruits"),
                        new Category("Dried")
                )
        );

        final List<CategoryDTO> categories = categoryService.findAll();
        assertThat(categories).hasSize(2);
        assertThat(categories.get(0).getName()).isEqualTo("Fruits");
        assertThat(categories.get(0).getCategoryUrl()).isEqualTo("/shop/categories/Fruits");
    }

    @Test(expected = CategoryNotFoundException.class)
    public void findAll_whenCategoriesNotFound() {
        given(categoryRepository.findAll()).willReturn(null);

        categoryService.findAll();
    }
}
