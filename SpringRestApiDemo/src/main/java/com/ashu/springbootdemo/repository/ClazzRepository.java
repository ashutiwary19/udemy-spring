package com.ashu.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.springbootdemo.model.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {

}
