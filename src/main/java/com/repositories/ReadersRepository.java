package com.repositories;

import com.entities.ReadersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReadersRepository extends JpaRepository<ReadersEntity, Integer> {

}