package com.SpringHexagonal.adapter_rest.adapter;

import com.SpringHexagonal.adapter_rest.controller.IPersonApi;
import com.SpringHexagonal.adapter_rest.mapper.IPersonRestMapper;
import com.SpringHexagonal.adapter_rest.model.PersonRest;
import com.SpringHexagonal.adapter_rest.controller.response.ApiError;
import com.SpringHexagonal.domain.exceptions.PersonNotFoundException;
import com.SpringHexagonal.domain.model.PersonDomain;
import com.SpringHexagonal.domain.ports.application.IRestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class PersonController implements IPersonApi {

    private final IRestPort personService;

    @Override
    public ResponseEntity<?> getPerson(String dni) {
        try {
            PersonDomain personDomain = personService.getPerson(dni);
            PersonRest personRest = IPersonRestMapper.toRest(personDomain);
            return ResponseEntity.ok(personRest);
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()));
        }
    }

    @Override
    public ResponseEntity<List<PersonRest>> getAllPersons() {
        List<PersonDomain> personDomains = personService.getAllPersons();
        List<PersonRest> personRestList = IPersonRestMapper.toRestList(personDomains);
        return ResponseEntity.ok(personRestList);
    }

    @Override
    public ResponseEntity<?> createPerson( PersonRest personRest) {
        PersonDomain personDomain = IPersonRestMapper.toDomain(personRest);
        PersonDomain createdPerson = personService.createPerson(personDomain);
        PersonRest createdPersonRest = IPersonRestMapper.toRest(createdPerson);
        return new ResponseEntity<>(createdPersonRest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updatePerson( PersonRest personRest) {
        try {
            PersonDomain personDomain = IPersonRestMapper.toDomain(personRest);
            PersonDomain updatedPerson = personService.updatePerson(personDomain);
            PersonRest updatedPersonRest = IPersonRestMapper.toRest(updatedPerson);

            return ResponseEntity.ok(updatedPersonRest);
        }catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()));
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
        }
    }

    @Override
    public ResponseEntity<?> deletePerson(String dni) {
        try {
            String message = personService.deletePerson(dni);
            return ResponseEntity.ok(message);
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
        }
    }

}

