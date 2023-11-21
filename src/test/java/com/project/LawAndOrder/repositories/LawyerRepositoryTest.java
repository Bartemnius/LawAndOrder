package com.project.LawAndOrder.repositories;

import com.project.LawAndOrder.entities.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LawyerRepositoryTest {

    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private TestEntityManager entityManager;

}