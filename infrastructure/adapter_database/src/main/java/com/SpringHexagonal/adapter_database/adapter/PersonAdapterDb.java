package com.SpringHexagonal.adapter_database.adapter;

import com.SpringHexagonal.adapter_database.mapper.IPersonMapper;
import com.SpringHexagonal.adapter_database.model.PersonModel;
import com.SpringHexagonal.adapter_database.repositories.IPersonsRepository;
import com.SpringHexagonal.domain.model.PersonDomain;
import com.SpringHexagonal.domain.ports.infrastructure.IDatabasePort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonAdapterDb implements IDatabasePort {

    private final IPersonsRepository databaseRepository;

    @Override
    public PersonDomain getPersonByDni(String dni) {

        PersonModel personModel = databaseRepository.findByDni(dni).orElseThrow(() -> new EntityNotFoundException("Person not found"));

        return IPersonMapper.toDomain(personModel);
    }
}
