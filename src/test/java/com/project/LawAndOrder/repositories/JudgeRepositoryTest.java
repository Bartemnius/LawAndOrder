package com.project.LawAndOrder.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JudgeRepositoryTest {

    @Autowired
    private JudgeRepository judgeRepository;

    @Autowired
    private TestEntityManager entityManager;

}