package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserDTO {
    private long id;
    private String role;
}
