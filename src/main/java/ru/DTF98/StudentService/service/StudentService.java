package ru.DTF98.StudentService.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.DTF98.StudentService.dto.InputStudentDTO;
import ru.DTF98.StudentService.dto.OutputStudentDTO;
import ru.DTF98.StudentService.exception.NotFoundStudentException;
import ru.DTF98.StudentService.model.Student;
import ru.DTF98.StudentService.repository.StudentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentService {
    private final StudentRepository repository;

    public OutputStudentDTO create(InputStudentDTO inputDto) {
        Student newStudent = new Student(null, inputDto.firstName(),
                inputDto.lastName(), inputDto.patronymic(), inputDto.groupStudents(), inputDto.averageGrade());
        newStudent = repository.save(newStudent);
        log.info("Добавлена информация о студенте {}", newStudent);
        return OutputStudentDTO.builder()
                .id(newStudent.getId())
                .firstName(newStudent.getFirstName())
                .lastName(newStudent.getLastName())
                .patronymic(newStudent.getPatronymic())
                .groupStudents(newStudent.getGroupStudents())
                .averageGrade(newStudent.getAverageGrade())
                .build();
    }

    public OutputStudentDTO update(InputStudentDTO inputDto) {
        Student studentForUpdate = repository.findById(inputDto.id()).orElseThrow(() ->
                new NotFoundStudentException(String.format("Не найден студент с id = %s", inputDto.id())));
        Student updateStudent = Student.builder()
                .id(studentForUpdate.getId())
                .firstName(inputDto.firstName())
                .lastName(inputDto.lastName())
                .patronymic(inputDto.patronymic())
                .groupStudents(inputDto.groupStudents())
                .averageGrade(inputDto.averageGrade())
                .build();
        updateStudent = repository.save(updateStudent);
        log.info("Обновлена информация о студенте {}", updateStudent);
        return OutputStudentDTO.builder()
                .id(updateStudent.getId())
                .firstName(updateStudent.getFirstName())
                .lastName(updateStudent.getLastName())
                .patronymic(updateStudent.getPatronymic())
                .groupStudents(updateStudent.getGroupStudents())
                .averageGrade(updateStudent.getAverageGrade())
                .build();
    }

    @Transactional(readOnly = true)
    public OutputStudentDTO getById(Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            Student studentForDto = student.get();
            log.info("Получена информация о студенте {}", studentForDto);
            return OutputStudentDTO.builder()
                    .id(studentForDto.getId())
                    .firstName(studentForDto.getFirstName())
                    .lastName(studentForDto.getLastName())
                    .patronymic(studentForDto.getPatronymic())
                    .groupStudents(studentForDto.getGroupStudents())
                    .averageGrade(studentForDto.getAverageGrade())
                    .build();
        } else {
            throw new NotFoundStudentException(String.format("Не найден студент с id = %s", id));
        }
    }

    public OutputStudentDTO delete(Long id) {
        OutputStudentDTO deletedStudent = getById(id);
        repository.deleteById(id);
        log.info("Удалена информация о студенте {}", deletedStudent);
        return deletedStudent;
    }
}
