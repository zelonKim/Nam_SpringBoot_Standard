package com.fastcampus.ch4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Value("${uploadPath}")
    private String uploadPath;


    @GetMapping("/uploadForm")
    public String showUploadForm() {
        return "/board/uploadFile";
    }

    @PostMapping("/deleteFile")
    public ResponseEntity<String> deleteFile(String filename) {
        System.out.println("filename = " + filename);

        File file = new File(uploadPath + filename);
        file.delete();
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }



    @GetMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(String filename) {
        System.out.println("filename = " + filename);
        Resource resource = (Resource) new FileSystemResource(uploadPath + filename);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


//    @PostMapping("/uploadFile")
 @PostMapping("/uploadAjax")
 @ResponseBody
 public ResponseEntity<List<String>> uploadFile(MultipartFile[] files) throws IOException {
        List<String> list = new ArrayList<>();

        for(MultipartFile file : files) {
            System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
            System.out.println("file.getSize() = " + file.getSize());

            File upFile = new File(uploadPath, file.getOriginalFilename());
            file.transferTo(upFile); // 업로드된 파일을 /upload에 저장함.

            list.add(file.getOriginalFilename());
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/modify")
    public String modify(Long bno, Model model) {
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "/board/write";
    }

    @PostMapping("/modify")
    public String modify(Board board) {
        boardService.modify(board);

        return "redirect:/board/list";
    }


    @GetMapping("/write")
    public String showWriteForm(Model model) {
        Board board = new Board();
        User user = new User();
        user.setId("aaa");
        board.setUser(user);

        model.addAttribute("board", board);
        return "/board/write";
    }


    @PostMapping("/write")
    public String wirte(Board board) {
        board.setBno(11L);
        User user = new User();
        user.setId("aaa");
        board.setUser(user);
        board.setViewCnt(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());
        boardService.write(board);

        return "redirect:/board/list";
    }



    @PostMapping("/remove")
    public String remove(Long bno) {
        boardService.remove(bno);
        return "redirect:/board/list"; //
    }


    @GetMapping("/read")
    public String read(Long bno, Model model) {
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "/board/read";
    }

        @GetMapping("/list")
    public String getList(Model model) {
        List<Board> list = boardService.getList();
        model.addAttribute("list",list);
        return "/board/list";
    }


}
