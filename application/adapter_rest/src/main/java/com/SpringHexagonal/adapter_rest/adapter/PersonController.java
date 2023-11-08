package com.SpringHexagonal.adapter_rest.adapter;

import com.SpringHexagonal.adapter_rest.controller.IPersonApi;
import com.SpringHexagonal.adapter_rest.mapper.IPersonRestMapper;
import com.SpringHexagonal.adapter_rest.model.PersonRest;
import com.SpringHexagonal.domain.model.PersonDomain;
import com.SpringHexagonal.domain.ports.application.IRestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController implements IPersonApi {

    private final IRestPort personService;

    @Override
    public PersonRest getPerson(String dni) {

        PersonDomain person = personService.getPerson(dni);

        return IPersonRestMapper.toRest(person);
    }
}
