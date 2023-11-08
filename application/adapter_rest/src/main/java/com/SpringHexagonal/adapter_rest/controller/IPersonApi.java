package com.SpringHexagonal.adapter_rest.controller;

import com.SpringHexagonal.adapter_rest.model.PersonRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1")
public interface IPersonApi {

    @GetMapping("/person/{dni}")
    PersonRest getPerson(@PathVariable String dni);
}
