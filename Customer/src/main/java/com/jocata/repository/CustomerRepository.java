package com.jocata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.entity.CustomerIdentity;

@Repository

public interface CustomerRepository extends JpaRepository<CustomerIdentity, Integer> {

	List<CustomerIdentity> findByIdnum(String name);
	
  
  
  

}
