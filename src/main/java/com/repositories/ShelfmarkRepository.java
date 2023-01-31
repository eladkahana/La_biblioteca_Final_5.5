package com.repositories;

import com.entities.Shelfmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShelfmarkRepository extends JpaRepository<Shelfmark, Integer>, JpaSpecificationExecutor<Shelfmark> {

}