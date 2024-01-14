package com.fastcampus.ch4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;

@SpringBootApplication
//public class Ch4Application implements CommandLineRunner {
public class Ch4Application {

    @Autowired
    EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Ch4Application.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

/*
    @Override
    public void run(String... args) throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();
        System.out.println(em); // SessionImpl(2019910824<open>)
        System.out.println(em2); // SessionImpl(48423187<open>)

        EntityTransaction tx = em.getTransaction();

        User user = new User();
        user.setId("aaa");
        user.setPassword("1234");
        user.setName("Lee");
        user.setEmail("aaa@naver.com");
        user.setInDate(new Date());
        user.setUpDate(new Date());

        tx.begin();

        // 저장
        em.persist(user); // user 엔티티를 EntityManager에 저장함.(INSERT문)

        // 변경
        user.setPassword("4321"); // Persistence Context가 변경 감지 (UPDATE문)
        user.setEmail("bbb@naver.com");
        tx.commit();

        // 조회
        User user2 = em.find(User.class, "aaa"); // EntityManager에 있으면 SQL문으로 DB를 조회하지 않음.
        System.out.println("user2 = " + user2); // User{id='aaa', password='4321', name='Lee', email='bbb@naver.com', inDate=Thu Jan 11 16:17:02 KST 2024, upDate=Thu Jan 11

        User user3 = em.find(User.class, "bbb"); // EntityManager에 없으면 SQL문으로 DB를 조회함.
        System.out.println("user3 = " + user3); // null

        // 삭제
        tx.begin();
        em.remove(user);
        tx.commit();
    }*/

}


















