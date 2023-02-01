package com.repositories;

import com.entities.AudienceVsBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AudienceVSBookRepository extends JpaRepository<AudienceVsBookEntity, Integer>{

}