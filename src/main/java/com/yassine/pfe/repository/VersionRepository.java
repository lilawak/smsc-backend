package com.yassine.pfe.repository;

import com.yassine.pfe.entity.Versions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends JpaRepository<Versions, Long> {
}