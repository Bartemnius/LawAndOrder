package com.project.LawAndOrder.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long clientId;

    private String firstName;
    private String lastName;
    private String homeAddress;
    private String phoneNumber;


}


