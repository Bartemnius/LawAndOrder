package com.project.LawAndOrder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lawyer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long lawyerId;

    private String firstName;
    private String lastName;
    private String company;
}
