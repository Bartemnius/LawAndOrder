package com.project.LawAndOrder.repositories;

import com.project.LawAndOrder.entities.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
}
