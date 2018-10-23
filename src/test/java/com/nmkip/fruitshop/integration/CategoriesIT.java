package com.nmkip.fruitshop.integration;

import com.nmkip.fruitshop.dto.CategoriesDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CategoriesIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCategories() {

        final ResponseEntity<CategoriesDTO> responseEntity = restTemplate.getForEntity("/categories", CategoriesDTO.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getCategories()).hasSize(1);
        assertThat(responseEntity.getBody().getCategories().get(0).getName()).isEqualTo("Fruits");
        assertThat(responseEntity.getBody().getCategories().get(0).getCategoryUrl()).isEqualTo("/shop/categories/Fruits");
    }

}
