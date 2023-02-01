package com.repositories;

import com.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{

}