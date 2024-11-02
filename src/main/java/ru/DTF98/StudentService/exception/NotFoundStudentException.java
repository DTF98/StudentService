package ru.DTF98.StudentService.exception;

public class NotFoundStudentException extends RuntimeException {

    public NotFoundStudentException(String msg) {
        super(msg);
    }
}