package com.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;

//public interface CustomerRepository extends CrudRepository<Customer, Integer>  {
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>  {
}
