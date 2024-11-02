package ru.DTF98.StudentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.DTF98.StudentService.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
