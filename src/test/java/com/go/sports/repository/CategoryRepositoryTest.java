package com.go.sports.repository;

import com.go.sports.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldLoadEventById(){

        UUID uuid = UUID.randomUUID();
        String eventId =  uuid.toString();

        Category category1 = new Category();
        category1.setTitle("30 KM leve");
        category1.setDescription("Esse categoria para quem não possui experiencia e facilitar subida sem suor");
        category1.setEventId(eventId);

        Category category2 = new Category();
        category2.setTitle("50 KM Pesado");
        category2.setDescription("Esse categoria para quem possui experiencia e terá subida pesado, baita desafio.");
         category2.setEventId(eventId);

        List<Category> list = new ArrayList<>();
        list.add(category1);
        list.add(category2);


        entityManager.persist(list);

        Category result = categoryRepository.getById(list.get(0).getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(category1, result);
    }
}
