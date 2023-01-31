package com.repositories;

import com.entities.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AudienceRepository extends JpaRepository<Audience, Integer>, JpaSpecificationExecutor<Audience> {

}