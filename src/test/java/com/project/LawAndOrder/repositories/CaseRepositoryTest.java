package com.project.LawAndOrder.repositories;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


//TODO: will be developed later on

@DataJpaTest
class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private TestEntityManager entityManager;

}