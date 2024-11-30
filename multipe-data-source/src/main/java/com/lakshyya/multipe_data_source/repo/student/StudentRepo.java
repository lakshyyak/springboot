package com.lakshyya.multipe_data_source.repo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lakshyya.multipe_data_source.entities.student.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{

}
