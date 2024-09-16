package com.yazon.api.repository;

import com.yazon.api.entity.CollectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectRepository extends JpaRepository<CollectEntity, Long> {
}
