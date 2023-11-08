package com.SpringHexagonal.domain.services;

import com.SpringHexagonal.domain.model.PersonDomain;
import com.SpringHexagonal.domain.ports.application.IRestPort;
import com.SpringHexagonal.domain.ports.infrastructure.IDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService implements IRestPort {

    private final IDatabasePort databasePort;

    public PersonDomain getPerson(String dni) {

        return databasePort.getPersonByDni(dni);
    }
}
