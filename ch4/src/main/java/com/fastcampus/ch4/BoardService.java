package com.fastcampus.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepo;


    public List<Board> getList() {
        return (List<Board>) boardRepo.findAll();
    }


    public Board write(Board board) {
        return boardRepo.save(board);
    }


    public Board read(Long bno) {
        return boardRepo.findById(bno).orElse(null);
    }


    public Board modify(Board newBoard) {
        Board board = boardRepo.findById(newBoard.getBno()).orElse(null);

        if(board==null) return null;
        board.setTitle(newBoard.getTitle());
        board.setContent(newBoard.getContent());

        return boardRepo.save(board);
    }


    public void remove(Long bno) {
        Board board = boardRepo.findById(bno).orElse(null);

        if(board!=null) boardRepo.deleteById(bno);

    }


}
