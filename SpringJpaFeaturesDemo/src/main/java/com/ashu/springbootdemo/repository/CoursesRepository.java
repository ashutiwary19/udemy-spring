package com.ashu.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
