package com.fastcampus.ch4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ManyToOneTest {

    @Autowired
    public EntityManager em;

    @Autowired
    private BoardRepository boardRepo;

    @Autowired
    private UserRepository userRepo;

    // @Transactional
    @Test
    public void manyToOneTest() {
        User user = new User();
        user.setId("aaa");
        user.setPassword("1234");
        user.setName("LEE");
        user.setEmail("aaa@aaa.com");
        user.setInDate(new Date());
        user.setUpDate(new Date());
        userRepo.save(user);

        Board b1 = new Board();
        b1.setBno(1L);
        b1.setTitle("title1");
        b1.setContent("content1");
        b1.setUser(user);
        b1.setViewCnt(0L);
        b1.setInDate(new Date());
        b1.setUpDate(new Date());
        boardRepo.save(b1);

        Board b2 = new Board();
        b2.setBno(2L);
        b2.setTitle("title2");
        b2.setContent("content2");
        b2.setUser(user);
        b2.setViewCnt(0L);
        b2.setInDate(new Date());
        b2.setUpDate(new Date());
        boardRepo.save(b2);

        b1 = boardRepo.findById(1L).orElse(null);
        b2 = boardRepo.findById(2L).orElse(null);

        System.out.println("b1 = " + b1); // Board{bno=1, title='title1', writer='null', content='content1', viewCnt=0, user=User{id='aaa', password='1234', name='LEE', email='aaa@aaa.com', inDate=2024-01-13 17:09:24.913, upDate=2024-01-13 17:09:24.913}, inDate=2024-01-13 17:09:24.922, upDate=2024-01-13 17:09:24.922}
        System.out.println("b2 = " + b2); // Board{bno=2, title='title2', writer='null', content='content2', viewCnt=0, user=User{id='aaa', password='1234', name='LEE', email='aaa@aaa.com', inDate=2024-01-13 17:09:24.913, upDate=2024-01-13 17:09:24.913}, inDate=2024-01-13 17:09:24.932, upDate=2024-01-13 17:09:24.932}

        assertTrue(b1!=null);
        assertTrue(b2!=null);

        user = userRepo.findById(user.getId()).orElse(null);
        System.out.println("user = " + user); // User{id='aaa', password='1234', name='LEE', email='aaa@aaa.com', list=[Board{bno=1, title='title1', writer='null', content='content1', viewCnt=0, inDate=2024-01-13 17:28:42.408, upDate=2024-01-13 17:28:42.408}, Board{bno=2, title='title2', writer='null', content='content2', viewCnt=0, inDate=2024-01-13 17:28:42.418, upDate=2024-01-13 17:28:42.418}], inDate=2024-01-13 17:28:42.39, upDate=2024-01-13 17:28:42.39}
        // System.out.println("user.getList() = " + user.getList());
        assertTrue(user!=null);

    }
}






