package ru.DTF98.StudentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.DTF98.StudentService.config.RsaKeyConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfigProperties.class)
public class StudentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
}
