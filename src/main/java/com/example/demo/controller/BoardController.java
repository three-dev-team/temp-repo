package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/register")
    public String register() {
        return "board/register";
    }

    @PostMapping("/board/register")
    public String register(BoardDTO boardDTO){
        Long bno = boardService.insert(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String list() {
        return "board/list";
    }

    @GetMapping("/board/detail")
    public String detail() {
        return "board/detail";
    }
}