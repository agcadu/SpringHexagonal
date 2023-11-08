package com.SpringHexagonal.adapter_rest.mapper;

import com.SpringHexagonal.adapter_rest.model.PersonRest;
import com.SpringHexagonal.domain.model.PersonDomain;

import java.util.List;
import java.util.stream.Collectors;


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

    static List<PersonDomain> toDomainList(List<PersonRest> personRestList) {
        return personRestList.stream()
                .map(IPersonRestMapper::toDomain)
                .collect(Collectors.toList());
    }

    static List<PersonRest> toRestList(List<PersonDomain> personDomainList) {
        return personDomainList.stream()
                .map(IPersonRestMapper::toRest)
                .collect(Collectors.toList());
    }
}

