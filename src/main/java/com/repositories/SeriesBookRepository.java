package com.repositories;

import com.entities.SeriesBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeriesBookRepository extends JpaRepository<SeriesBook, Integer>, JpaSpecificationExecutor<SeriesBook> {

}