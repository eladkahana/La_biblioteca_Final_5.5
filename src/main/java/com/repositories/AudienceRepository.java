package com.repositories;

import com.entities.AudienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AudienceRepository extends JpaRepository<AudienceEntity, Integer>{

}