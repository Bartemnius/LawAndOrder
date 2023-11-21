package com.project.LawAndOrder.repositories;

import com.project.LawAndOrder.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
}
