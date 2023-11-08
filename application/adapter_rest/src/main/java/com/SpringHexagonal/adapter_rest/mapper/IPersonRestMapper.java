package com.SpringHexagonal.adapter_rest.mapper;

import com.SpringHexagonal.adapter_rest.model.PersonRest;
import com.SpringHexagonal.domain.model.PersonDomain;


public interface IPersonRestMapper {

    static PersonDomain toDomain(PersonRest personRest) {
        if (personRest == null) {
            return null;
        }
        PersonDomain personDomain = new PersonDomain();
        personDomain.setName(personRest.getName());
        personDomain.setLastName(personRest.getLastName());
        personDomain.setDni(personRest.getDni());
        personDomain.setEmail(personRest.getEmail());

        return personDomain;
    }

    static PersonRest toRest(PersonDomain personDomain) {
        if (personDomain == null) {
            return null;
        }
        PersonRest personRest = new PersonRest();
        personRest.setName(personDomain.getName());
        personRest.setLastName(personDomain.getLastName());
        personRest.setDni(personDomain.getDni());
        personRest.setEmail(personDomain.getEmail());

        return personRest;
    }
}

