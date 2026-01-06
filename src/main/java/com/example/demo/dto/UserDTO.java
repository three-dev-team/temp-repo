package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private LocalDateTime lastLogin;
    private LocalDateTime regDate, updateDate;
    private List<AuthUserDTO> authList;
}
