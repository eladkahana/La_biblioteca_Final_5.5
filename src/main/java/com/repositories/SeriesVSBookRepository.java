package com.repositories;

import com.entities.SeriesVsBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeriesVSBookRepository extends JpaRepository<SeriesVsBookEntity, Integer> {


}