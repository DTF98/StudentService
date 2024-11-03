package ru.DTF98.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
@AllArgsConstructor
@Getter
public class InputRegisterDTO {

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String email;
}
