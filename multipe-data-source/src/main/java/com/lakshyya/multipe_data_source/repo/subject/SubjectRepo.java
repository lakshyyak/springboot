package com.lakshyya.multipe_data_source.repo.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lakshyya.multipe_data_source.entities.subject.Subject;

public interface SubjectRepo extends CrudRepository<Subject, Integer>{

}