package com.repositories;

import com.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {

}