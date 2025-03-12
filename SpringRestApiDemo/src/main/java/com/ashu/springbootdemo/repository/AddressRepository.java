package com.ashu.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.springbootdemo.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
