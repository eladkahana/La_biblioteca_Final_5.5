package com.repositories;

import com.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReserveRepository extends JpaRepository<Reserve, Integer>, JpaSpecificationExecutor<Reserve> {

}