package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "authList")
@Builder
@Table(name = "user")
public class User extends TimeBase {

    @Id
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(name="last_login")
    private LocalDateTime lastLogin;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<AuthUser> authList = new ArrayList<>();

    public void addAuth(AuthRole role) {
        if(this.authList == null) {
            this.authList = new ArrayList<>();
        }

        this.authList.add(AuthUser.builder()
                .user(this)
                .role(role)
                .build());
    }
}