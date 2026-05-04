package com.yassine.pfe.repository;

import com.yassine.pfe.entity.Planification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlanificationRepository extends JpaRepository<Planification, Long> {
    List<Planification> findByDateLivraisonPrevueBetween(LocalDate start, LocalDate end);
}
