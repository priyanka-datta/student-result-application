package com.priyanka.datta;

import com.priyanka.datta.entity.Student;
import com.priyanka.datta.repository.StudentRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(version = "1.0.0",title = "student result app"))
public class SpringStudentJava8Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentJava8Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		List<Student> students = Arrays.asList(new Student(1,"Priyanka",89.5,"BARASAT"),
				new Student(2,"Arun",81.5,"Saltlake"),
				new Student(3,"Ananya",92.0,"BARASAT"),
				new Student(4,"Bikas",81.0,"NewTown"),
				new Student(5,"Arnab",87.0,"NewTown"),
				new Student(6,"Rishav",93.0,"Saltlake"),
				new Student(7,"Pritam",84.0,"NewTown"));
		studentRepository.saveAll(students);
	}
}
