package com.example.demo.service;

import com.example.demo.dto.AuthUserDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.AuthUser;
import com.example.demo.entity.User;

public interface UserService {

    // UserDTO -> User Entity
    default User convertDtoToEntity(UserDTO userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .lastLogin(userDto.getLastLogin())
                .build();
    }

    // User Entity -> UserDTO
    default UserDTO convertEntityToDto(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .lastLogin(user.getLastLogin())
                .regDate(user.getRegDate())
                .updateDate(user.getUpdateDate())
                .authList(user.getAuthList()==null ?
                        null : user.getAuthList().stream()
                        .map(this::convertAuthEntityToDto).toList()
                )
                .build();
    }

    default AuthUserDTO convertAuthEntityToDto(AuthUser authUser) {
        return AuthUserDTO.builder()
                .id(authUser.getId())
                .role(authUser.getRole().name())
                .build();
    }

    String insertUser(UserDTO userDTO);
}
