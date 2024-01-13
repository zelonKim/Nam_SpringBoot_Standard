package com.fastcampus.ch4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
/*
    @Query("SELECT b FROM Board b")
    List<Board> findAllBoard();

    @Query("SELECT b FROM Board b WHERE b.title = ?1 AND b.writer=?2")
    List<Board> findByTitleAndWriter2(String title, String writer);

    @Query("SELECT b FROM Board b WHERE b.title = :title AND b.writer= :writer")
    List<Board> findByTitleAndWriter3(String title, String writer);




    @Query(value="SELECT * FROM Board", nativeQuery=true)
    List<Board> findAllBoardBySQL(); // 전체 컬럼을 조회할 경우에는 타입을 List<엔티티명>으로 해줘야 함.


    @Query(value="SELECT title, writer FROM Board", nativeQuery=true )
    List<Object[]> findAllBoardBySQL2(); // 일부 컬럼만 조회할 경우에는 타입을 List<Object[]>으로 해줘야 함.






    int countAllByWriter(String writer); // SELECT COUNT(*) FROM Board WHERE Writer = :writer

    List<Board> findByWriter(String writer); // SELECT * FROM Board WHERE Writer = :writer

    List<Board> findByTitleAndWriter(String title, String writer); // SELECT * FROM Board WHERE Title = :title AND Writer = :writer


    @Transactional // delete의 경우, 필수로 트랜잭션 처리를 해줘야 함.
    int deleteByWriter(String writer); // DELETE FROM Board WHERE Writer =: writer
*/

}
