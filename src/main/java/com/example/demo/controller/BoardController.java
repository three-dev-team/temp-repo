package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public void list(Model model) {
        List<BoardDTO> list = boardService.getList();
        model.addAttribute("list",list);
    }

    @GetMapping("/board/detail")
    public String detail(@RequestParam("bno") long bno, Model model) {
        BoardDTO boardDTO = boardService.getDetail(bno);
        model.addAttribute("board", boardDTO);
        return "board/detail";
    }
}
