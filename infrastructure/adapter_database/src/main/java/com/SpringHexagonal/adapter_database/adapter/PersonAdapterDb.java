package com.SpringHexagonal.adapter_database.adapter;

import com.SpringHexagonal.adapter_database.mapper.IPersonMapper;
import com.SpringHexagonal.adapter_database.model.PersonModel;
import com.SpringHexagonal.adapter_database.repositories.IPersonsRepository;
import com.SpringHexagonal.domain.model.PersonDomain;
import com.SpringHexagonal.domain.ports.infrastructure.IDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonAdapterDb implements IDatabasePort {

    private final IPersonsRepository databaseRepository;

    @Override
    public Optional<PersonDomain> getPersonByDni(String dni) {
        return databaseRepository.findByDni(dni)
                .map(IPersonMapper::toDomain);
    }
    @Override
    public List<PersonDomain> getAllPersons() {
        List<PersonModel> personModels = databaseRepository.findAll();
        return IPersonMapper.toDomainList(personModels);
    }

    @Override
    public PersonDomain savePerson(PersonDomain personDomain) {
        PersonModel personModel = IPersonMapper.toModel(personDomain);
        PersonModel savedPersonModel = databaseRepository.save(personModel);
        return IPersonMapper.toDomain(savedPersonModel);
    }

    @Override
    @Transactional
    public Optional<PersonDomain> deletePerson(String dni) {
        PersonModel personModel = databaseRepository.findByDni(dni).orElseThrow();
        databaseRepository.deleteByDni(personModel.getDni());
        return Optional.ofNullable(IPersonMapper.toDomain(personModel));

    }

}

