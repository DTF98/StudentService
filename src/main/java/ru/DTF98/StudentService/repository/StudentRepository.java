package ru.DTF98.StudentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.DTF98.StudentService.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
