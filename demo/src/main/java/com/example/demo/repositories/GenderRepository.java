package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entities.Gender;

public interface GenderRepository extends CrudRepository <Gender, Integer>, PagingAndSortingRepository <Gender, Integer> {

}
