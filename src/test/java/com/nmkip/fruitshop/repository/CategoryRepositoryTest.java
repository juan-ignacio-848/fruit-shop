package com.nmkip.fruitshop.repository;

import com.nmkip.fruitshop.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAll_returnsCategories() {

        entityManager.persistFlushFind(new Category("Fruits"));
        entityManager.persistFlushFind(new Category("Dried"));
        final List<Category> categories = repository.findAll();

        assertThat(categories).hasSize(2);
    }
    
}