package com.SpringHexagonal.adapter_rest.controller;

import com.SpringHexagonal.adapter_rest.model.PersonRest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
public interface IPersonApi {

    @GetMapping("/person/{dni}")
    ResponseEntity<?> getPerson(@PathVariable String dni);

    @GetMapping("/persons")
    ResponseEntity<List<PersonRest>> getAllPersons();

    @PostMapping("/person")
    ResponseEntity<?> createPerson(@Valid @RequestBody PersonRest personRest);

}

