package com.nmkip.fruitshop.controller;

import com.nmkip.fruitshop.dto.CategoriesDTO;
import com.nmkip.fruitshop.dto.CategoryDTO;
import com.nmkip.fruitshop.exception.CategoryNotFoundException;
import com.nmkip.fruitshop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void getCategories_shouldReturnListOfCategories() throws Exception {

        given(categoryService.findAll()).willReturn(
            Arrays.asList(new CategoryDTO("Fruits", "/shop/categories/Fruits"))
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories[0].name").value("Fruits"))
                .andExpect(jsonPath("$.categories[0].category_url").value("/shop/categories/Fruits"));
    }

    @Test
    public void getCategories_shouldReturnStatus404WhenThereAreNoCategories() throws Exception {

        given(categoryService.findAll()).willThrow(new CategoryNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/categories"))
                .andExpect(status().isNotFound());
    }
}
