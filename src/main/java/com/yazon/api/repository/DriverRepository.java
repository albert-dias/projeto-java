package com.yazon.api.repository;

import com.yazon.api.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity,Long> {
}
