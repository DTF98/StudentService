package ru.DTF98.StudentService.dto;

import lombok.Builder;

@Builder
public record InputStudentDTO(Long id, String firstName, String lastName, String patronymic, String groupStudents,
                              String averageGrade) {
}
