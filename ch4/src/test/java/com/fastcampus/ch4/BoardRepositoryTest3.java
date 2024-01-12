package com.fastcampus.ch4;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest3 {

    @Autowired
    public EntityManager em;

    @Autowired
    private BoardRepository boardRepo;



    @BeforeEach
    public void testData() {
        for (int i=0; i <= 100; i++) {
            Board board = new Board();
            board.setBno((long)i);
            board.setTitle("title" + i);
            board.setContent("content" + i);
            board.setWriter("writer" + (i % 5));
            board.setViewCnt((long)(Math.random()*100));
            board.setInDate(new Date());
            board.setInDate(new Date());
            boardRepo.save(board);
        }
    }



    @Test
    public void queryAnnoTest5() {
        List<Object[]> list = boardRepo.findAllBoardBySQL2();
        list.stream().map(arr -> Arrays.toString(arr)).forEach(System.out::println);
    }



    @Test
    public void queryAnnoTest4() {
        List<Board> list = boardRepo.findAllBoardBySQL();
        assertTrue(list.size() == 100);
    }



    @Test
    public void queryAnnoTest3() {
        List<Board> list = boardRepo. findByTitleAndWriter3("title1", "writer1");
        assertTrue(list.size() == 1);
    }


    @Test
    public void queryAnnoTest2() {
        List<Board> list = boardRepo. findByTitleAndWriter2("title1", "writer1");
        assertTrue(list.size() == 1);
    }


    @Test
    public void queryAnnoTest() {
        List<Board> list = boardRepo.findAllBoard();
        assertTrue(list.size() == 100);

    }

    @Test
    public void createQueryTest() {
        String query = "SELECT b FROM Board b";
        TypedQuery<Board> tQuery = em.createQuery(query, Board.class);
        List<Board> list = tQuery.getResultList();

        assertTrue(list.size() == 100);
    }

}
