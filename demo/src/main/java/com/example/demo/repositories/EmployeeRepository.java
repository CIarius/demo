package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entities.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Integer>, PagingAndSortingRepository <Employee, Integer> {

}
