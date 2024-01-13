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
import java.util.Date;
import java.util.List;

import static com.fastcampus.ch4.QBoard.board;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OneToOneTest {

    @Autowired
    public EntityManager em;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void oneToOneTest() {
        Member member = new Member();
        member.setId(1L);
        member.setName("aaa");
        member.setEmail("aaa@naver.com");
        member.setPassword("1234");
        memberRepo.save(member);

        Cart cart = new Cart();
        cart.setId(1L);
        cart.setMember(member);
        cartRepo.save(cart);

        cart = cartRepo.findById(cart.getId()).orElse(null);
        assertTrue(cart != null);
        System.out.println(cart); // Cart{id=1, member=Member{id=1, password='1234', name='aaa', email='aaa@naver.com', cart=null}}

        member = memberRepo.findById(member.getId()).orElse(null);
        assertTrue(member != null);
        System.out.println(member); // Member{id=1, password='1234', name='aaa', email='aaa@naver.com', cart=null}

    }
}






