package com.project.LawAndOrder.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//"case" is a reserved word
@Table(name = "cases")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Case {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long caseId;

//    private Client client;
//    private Court court;
//    private Judge judge;
//    private Lawyer lawyer;
}
