package com.SpringHexagonal.domain.services;

import com.SpringHexagonal.domain.exceptions.DniAlreadyExistsException;
import com.SpringHexagonal.domain.exceptions.PersonNotFoundException;
import com.SpringHexagonal.domain.model.PersonDomain;
import com.SpringHexagonal.domain.ports.application.IRestPort;
import com.SpringHexagonal.domain.ports.infrastructure.IDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService implements IRestPort {

    private final IDatabasePort databasePort;

    @Override
    public PersonDomain getPerson(String dni) {

        return databasePort.getPersonByDni(dni).orElseThrow(() -> new PersonNotFoundException("No se encontró la persona con DNI: " + dni));
    }

    @Override
    public List<PersonDomain> getAllPersons() {
        return databasePort.getAllPersons();
    }

    @Override
    public PersonDomain createPerson(PersonDomain personDomain) {
        if (databasePort.getPersonByDni(personDomain.getDni()).isPresent()) {
            throw new DniAlreadyExistsException("El DNI proporcionado ya está registrado para otra persona: " + personDomain.getDni());
        }
        return databasePort.savePerson(personDomain);
    }

}

