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
    @SequenceGenerator(
            name = "case_sequence",
            sequenceName = "case_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "case_sequence"
    )
    private Long caseId;

    private String description;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "clientId"
    )
    private Client client;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "court_id",
            referencedColumnName = "courtId"
    )
    private Court court;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "judge_id",
            referencedColumnName = "judgeId"
    )
    private Judge judge;

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "lawyer_id",
            referencedColumnName = "lawyerId"
    )
    private Lawyer lawyer;
}
