package com.SpringHexagonal.domain.ports.infrastructure;

import com.SpringHexagonal.domain.model.PersonDomain;

import java.util.List;
import java.util.Optional;


public interface IDatabasePort {

    Optional<PersonDomain> getPersonByDni(String dni);
    List<PersonDomain> getAllPersons();
    PersonDomain savePerson(PersonDomain personDomain);
    Optional<PersonDomain> deletePerson(String dni);

}
