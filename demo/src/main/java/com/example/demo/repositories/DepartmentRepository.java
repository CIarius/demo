package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entities.Department;

public interface DepartmentRepository extends CrudRepository <Department, Integer>, PagingAndSortingRepository <Department, Integer> {

}
