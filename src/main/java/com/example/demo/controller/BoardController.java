package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {
    private final BoardService boardService;


    @GetMapping("/board/register")
    public String register() {
        return "board/register";
    }

    @GetMapping("/board/list")
    public void list(Model model) {
    }

    @GetMapping("/board/detail")
    public String detail() {
        return "board/detail";
    }
}