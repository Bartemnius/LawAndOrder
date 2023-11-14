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
public class Court {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long courtId;

    //TODO:maybe should be separated into street/city/zip code?
    // alternative : create a address class (something to think about)
    private String address;
}
