package ru.DTF98.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
@AllArgsConstructor
@Getter
public class InputRegisterDTO {

    @NonNull
    String username;

    @NonNull
    String password;

    @NonNull
    String email;
}
