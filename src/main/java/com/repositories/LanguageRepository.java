package com.repositories;

import com.entities.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

}