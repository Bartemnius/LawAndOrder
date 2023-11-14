package com.project.LawAndOrder.repositories;

import com.project.LawAndOrder.entities.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, Long> {
}
