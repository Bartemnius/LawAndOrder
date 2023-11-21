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

    private String description;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "clientId"
    )
    private Client client;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "court_id",
            referencedColumnName = "courtId"
    )
    private Court court;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "judge_id",
            referencedColumnName = "judgeId"
    )
    private Judge judge;

    @ManyToOne(
            cascade = CascadeType.ALL

    )
    @JoinColumn(
            name = "lawyer_id",
            referencedColumnName = "lawyerId"
    )
    private Lawyer lawyer;
}
