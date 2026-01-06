package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board/write")
    public String write() {
        return "board/write";
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