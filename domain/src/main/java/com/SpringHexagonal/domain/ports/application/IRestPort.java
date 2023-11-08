package com.SpringHexagonal.domain.ports.application;

import com.SpringHexagonal.domain.model.PersonDomain;

import java.util.List;

public interface IRestPort {

    PersonDomain getPerson(String dni);
    List<PersonDomain> getAllPersons();
    PersonDomain createPerson(PersonDomain personDomain);

}
