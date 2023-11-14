package com.project.LawAndOrder.repositories;

import com.project.LawAndOrder.entities.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<Court, Long> {
}
