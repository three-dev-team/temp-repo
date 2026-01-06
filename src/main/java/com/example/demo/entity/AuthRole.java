package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// mybatis가 아닌 JPA에서는 권한은 보통 Enum 타입(열거형)으로 정의합니다.

@Getter
@RequiredArgsConstructor
public enum AuthRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String roleName;
}
