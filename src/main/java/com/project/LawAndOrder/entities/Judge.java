package com.project.LawAndOrder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Judge {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long judgeId;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
