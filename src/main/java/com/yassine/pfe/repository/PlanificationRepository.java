package com.yassine.pfe.repository;

import com.yassine.pfe.entity.Planification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationRepository extends JpaRepository<Planification, Long> {
}
