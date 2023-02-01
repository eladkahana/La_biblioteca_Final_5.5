package com.repositories;

import com.entities.BookVsCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookVSCategoryRepository extends JpaRepository<BookVsCategoryEntity, Integer>  {

}