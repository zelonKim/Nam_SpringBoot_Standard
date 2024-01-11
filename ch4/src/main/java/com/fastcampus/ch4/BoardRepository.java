package com.fastcampus.ch4;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    int countAllByWriter(String writer); // SELECT COUNT(*) FROM Board WHERE Writer = :writer

    List<Board> findByWriter(String writer); // SELECT * FROM Board WHERE Writer = :writer

    List<Board> findByTitleAndWriter(String title, String writer); // SELECT * FROM Board WHERE Title = :title AND Writer = :writer


    @Transactional // delete의 경우, 필수로 트랜잭션 처리를 해줘야 함.
    int deleteByWriter(String writer); // DELETE FROM Board WHERE Writer =: writer

}
