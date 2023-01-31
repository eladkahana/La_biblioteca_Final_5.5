package com.repositories;

import com.entities.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RequestsRepository extends JpaRepository<Requests, Integer>, JpaSpecificationExecutor<Requests> {

}