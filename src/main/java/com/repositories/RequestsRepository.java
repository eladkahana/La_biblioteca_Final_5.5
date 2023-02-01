package com.repositories;

import com.entities.RequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RequestsRepository extends JpaRepository<RequestsEntity, Integer>  {

}