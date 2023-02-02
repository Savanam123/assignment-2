package com.jocata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.entity.IdentityTypes;
@Repository

public interface IdentityTypeRepository extends JpaRepository<IdentityTypes, String>{

}
