package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer , Integer>{

	@Query("SELECT c FROM Customer c WHERE (:search is null or lower(c.phone) like lower(concat('%', :search,'%'))) ")
	Page<Customer> findAll(@Param("search") String searchText,Pageable pageInfo);
	
	@Query("SELECT COUNT(c) FROM Customer c WHERE (:search is null or lower(c.phone) like lower(concat('%', :search,'%'))) ")
	public long count(@Param("search") String searchText);
}
