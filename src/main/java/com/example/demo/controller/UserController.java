package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/signup")
    public void signup() {
    }

    @PostMapping("/signup")
    public String signupPost(UserDTO userDTO) {
        log.info(">>> ✅ 생성된 사용자 정보: " + userDTO);
        return "redirect:/user/login";
    }
}