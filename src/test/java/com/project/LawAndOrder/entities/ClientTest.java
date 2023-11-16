package com.project.LawAndOrder.entities;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientTest {


    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void shouldBeAbleToCreateClientWhenAllDataIsValid() {
        Client client = Client.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .homeAddress("street 4/20")
                .phoneNumber("123456789")
                .build();

        entityManager.persist(client);
        assertNotNull(client.getClientId());
    }

    @Test
    @Transactional
    public void shouldNotBeAbleToCreateClientWithNoFirstName() {
        Client client = Client.builder()
                .lastName("Kowalski")
                .homeAddress("street 4/20")
                .phoneNumber("123456789")
                .build();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Client>> constraintViolations = validator.validate(client);

        assertEquals(1, constraintViolations.size());
    }

    @Test
    @Transactional
    public void shouldNotBeAbleToCreateClientWithNoLastName() {
        Client client = Client.builder()
                .firstName("Jan")
                .homeAddress("street 4/20")
                .phoneNumber("123456789")
                .build();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Client>> constraintViolations = validator.validate(client);

        assertEquals(1, constraintViolations.size());
    }

}