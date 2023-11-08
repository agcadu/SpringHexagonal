package com.SpringHexagonal.adapter_database.mapper;

import com.SpringHexagonal.adapter_database.model.PersonModel;
import com.SpringHexagonal.domain.model.PersonDomain;

import java.util.List;
import java.util.stream.Collectors;

public interface IPersonMapper {


    static PersonDomain toDomain(PersonModel personModel) {
        if (personModel == null) {
            return null;
        }
        PersonDomain personDomain = new PersonDomain();
        personDomain.setName(personModel.getName());
        personDomain.setLastName(personModel.getLastName());
        personDomain.setDni(personModel.getDni());
        personDomain.setEmail(personModel.getEmail());

        return personDomain;
    }

    static PersonModel toModel(PersonDomain personDomain) {
        if (personDomain == null) {
            return null;
        }
        PersonModel personModel = new PersonModel();
        personModel.setName(personDomain.getName());
        personModel.setLastName(personDomain.getLastName());
        personModel.setDni(personDomain.getDni());
        personModel.setEmail(personDomain.getEmail());

        return personModel;
    }

    static List<PersonDomain> toDomainList(List<PersonModel> personModels) {
        if (personModels == null) {
            return null;
        }
        return personModels.stream()
                .map(IPersonMapper::toDomain)
                .collect(Collectors.toList());
    }

    static List<PersonModel> toModelList(List<PersonDomain> personDomains) {
        if (personDomains == null) {
            return null;
        }
        return personDomains.stream()
                .map(IPersonMapper::toModel)
                .collect(Collectors.toList());
    }
}
