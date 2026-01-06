package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/register")
    public String register() {
        return "board/register";
    }

    @GetMapping("/board/list")
    public String list() {
        return "board/list";
    }

    @GetMapping("/board/detail")
    public String detail(@RequestParam("bno") long bno, Model model) {
        BoardDTO boardDTO = boardService.getDetail(bno);
        model.addAttribute("board", boardDTO);
        return "board/detail";
    }
}
