package com.SpringHexagonal.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDomain {

        private String name;
        private String lastName;
        private String dni;
        private String email;
}
