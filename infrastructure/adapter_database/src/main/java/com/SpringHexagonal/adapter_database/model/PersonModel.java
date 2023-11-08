package com.SpringHexagonal.adapter_database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {

    private String name;

    private String lastName;

    @Id
    private String dni;

    private String email;
}
