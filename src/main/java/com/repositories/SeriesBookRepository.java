package com.repositories;

import com.entities.SeriesBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeriesBookRepository extends JpaRepository<SeriesBookEntity, Integer>  {

}