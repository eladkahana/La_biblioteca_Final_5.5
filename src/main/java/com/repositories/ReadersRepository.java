package com.repositories;

import com.entities.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReadersRepository extends JpaRepository<Readers, Integer>, JpaSpecificationExecutor<Readers> {

}