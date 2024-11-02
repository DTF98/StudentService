package ru.DTF98.StudentService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.DTF98.StudentService.dto.AuthDTO;
import ru.DTF98.StudentService.dto.InputRegisterDTO;
import ru.DTF98.StudentService.model.AuthUser;
import ru.DTF98.StudentService.model.User;
import ru.DTF98.StudentService.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@Validated
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody InputRegisterDTO inputRegisterDto) {
        log.info("Запрос на регистрацию пользователя {}", inputRegisterDto.toString());
        User newUser = authService.registerUser(new User(inputRegisterDto.getUsername(),
                inputRegisterDto.getEmail(), inputRegisterDto.getPassword()));
        return ResponseEntity.ok(newUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO.LoginRequest userLogin) throws IllegalAccessException {
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                userLogin.username(),
                                userLogin.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthUser userDetails = (AuthUser) authentication.getPrincipal();


        log.info("Запрос на получение токена доступа для пользователя :{}", authentication.getAuthorities().toString());
        String token = authService.generateToken(authentication);

        AuthDTO.Response response = new AuthDTO.Response("User logged in successfully", token);

        return ResponseEntity.ok(response);
    }
}
