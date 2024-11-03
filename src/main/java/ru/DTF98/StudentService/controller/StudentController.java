package ru.DTF98.StudentService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.DTF98.StudentService.dto.InputStudentDTO;
import ru.DTF98.StudentService.dto.OutputStudentDTO;
import ru.DTF98.StudentService.service.StudentService;

@RestController
@RequestMapping("/api/resource")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService service;

    @GetMapping("/{id}")
    public OutputStudentDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public OutputStudentDTO update(@RequestBody InputStudentDTO inputDto) {
        return service.update(inputDto);
    }

    @PutMapping
    public OutputStudentDTO create(@RequestBody InputStudentDTO inputDto) {
        return service.create(inputDto);
    }

    @DeleteMapping("/{id}")
    public OutputStudentDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
