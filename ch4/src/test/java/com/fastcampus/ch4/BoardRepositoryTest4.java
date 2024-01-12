package com.fastcampus.ch4;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.fastcampus.ch4.QBoard.board;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest4 {

    @Autowired
    public EntityManager em;

    @Autowired
    private BoardRepository boardRepo;


    @BeforeEach
    public void testData() {
        for (int i = 0; i <= 100; i++) {
            Board board = new Board();
            board.setBno((long) i);
            board.setTitle("title" + i);
            board.setContent("content" + i);
            board.setWriter("writer" + (i % 5));
            board.setViewCnt((long) (Math.random() * 100));
            board.setInDate(new Date());
            board.setInDate(new Date());
            boardRepo.save(board);
        }
    }

    @Test
    public void querydslTest3() {
        String searchBy = "TC"; // 제목 + 내용
        String keyword = "29";
        keyword = "%" + keyword + "%";

        BooleanBuilder builder = new BooleanBuilder();

        if(searchBy.equalsIgnoreCase("T"))
            builder.and(board.title.like(keyword));
        else if(searchBy.equalsIgnoreCase("C"))
            builder.and(board.content.like(keyword));
        else if(searchBy.equalsIgnoreCase("TC"))
            builder.and(board.title.like(keyword).or(board.content.like(keyword)));


        JPAQueryFactory qf = new JPAQueryFactory(em);

        JPAQuery query = qf.selectFrom(board)
                .where(builder)
                .orderBy(board.upDate.desc());

        List<Board> list = query.fetch();
        list.forEach(System.out::println); // Board{bno=29, title='title29', writer='writer4', content='content29', viewCnt=80, inDate=2024-01-12 14:23:43.332, upDate=null}


    }



    @Test
    public void querydslTest2() {
        //QBoard board = QBoard.board;

        JPAQueryFactory qf = new JPAQueryFactory(em);

        JPAQuery<Tuple> query = qf.select(board.writer, board.viewCnt.sum()).from(board)
                .where(board.title.notLike("title1%"))
                .where(board.writer.eq("writer1"))
                .where(board.content.contains("content"))
                .where(board.content.isNotNull())
                .groupBy(board.writer)
                .having(board.viewCnt.sum().gt(100))
                .orderBy(board.writer.asc())
                .orderBy(board.viewCnt.sum().desc());

        List<Tuple> list = query.fetch();

        list.forEach(System.out::println); // [writer1, 912]

    }



    @Test
    public void querydslTest1() {
        //QBoard board = QBoard.board;

        JPAQueryFactory qf = new JPAQueryFactory(em);

        JPAQuery<Board> query = qf.selectFrom(board).where(board.title.eq("title1")); // 쿼리 작성

        List<Board> list = query.fetch(); // 쿼리 실행

        list.forEach(System.out::println); // Board{bno=1, title='title1', writer='writer1', content='content1', viewCnt=10, inDate=2024-01-12 13:47:18.629, upDate=null}
    }

}



