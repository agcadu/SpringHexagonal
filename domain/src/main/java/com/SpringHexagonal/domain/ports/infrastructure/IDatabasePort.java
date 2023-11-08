package com.SpringHexagonal.domain.ports.infrastructure;

import com.SpringHexagonal.domain.model.PersonDomain;


public interface IDatabasePort {

    PersonDomain getPersonByDni(String dni);
}
