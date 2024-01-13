package com.fastcampus.ch4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ManyToManyTest {

    @Autowired
    public EntityManager em;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void manyToManyTest() {
        Product p1 = new Product();
        p1.setId(1L);
        p1.setName("iphone16");
        p1.setPrice(80L);
        productRepo.save(p1);


        Product p2 = new Product();
        p2.setId(2L);
        p2.setName("Mac");
        p2.setPrice(150L);
        productRepo.save(p2);


        Category c1 = new Category();
        c1.setId(1L);
        c1.setName("electronic");
        categoryRepo.save(c1);


        Category c2 = new Category();
        c2.setId(2L);
        c2.setName("newProduct");
        categoryRepo.save(c2);



        p1 = productRepo.findById(1L).orElse(null);
        p2 = productRepo.findById(2L).orElse(null);

        System.out.println("p1 = " + p1);
        System.out.println("p1 = " + p2);

        assertTrue(p1!=null);
        assertTrue(p2!=null);




        c1 = categoryRepo.findById(1L).orElse(null);
        c2 = categoryRepo.findById(2L).orElse(null);

        System.out.println("p1 = " + c1);
        System.out.println("p1 = " + c2);

        assertTrue(c1!=null);
        assertTrue(c2!=null);



    }

}




















