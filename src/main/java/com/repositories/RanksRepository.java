package com.repositories;

import com.entities.Ranks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RanksRepository extends JpaRepository<Ranks, Integer>, JpaSpecificationExecutor<Ranks> {

}