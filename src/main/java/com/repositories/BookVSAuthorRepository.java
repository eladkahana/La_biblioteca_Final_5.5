package com.repositories;

import com.entities.BookVsAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookVSAuthorRepository extends JpaRepository<BookVsAuthorEntity, Integer> {

}