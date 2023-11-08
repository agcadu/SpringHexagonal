package com.SpringHexagonal.adapter_rest.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonRest {

    private String name;
    private String lastName;
    private String dni;
    private String email;
}
