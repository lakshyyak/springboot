package com.lakshyya.multipe_data_source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lakshyya.multipe_data_source.entities.student.Student;
import com.lakshyya.multipe_data_source.entities.subject.Subject;
import com.lakshyya.multipe_data_source.repo.student.StudentRepo;
import com.lakshyya.multipe_data_source.repo.subject.SubjectRepo;

@SpringBootApplication
public class MultipeDataSourceApplication implements CommandLineRunner{

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	SubjectRepo subjectRepo;

	public static void main(String[] args) {
		SpringApplication.run(MultipeDataSourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = Student.builder().firstName("lakshyya").lastName("kothari").build();
		studentRepo.save(student);

		Subject subject = Subject.builder().subjectName("physics").build();
		subjectRepo.save(subject);
	}

}
