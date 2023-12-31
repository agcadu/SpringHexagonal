package com.SpringHexagonal.adapter_database.repositories;

import com.SpringHexagonal.adapter_database.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPersonsRepository extends JpaRepository<PersonModel, String> {

    Optional<PersonModel> findByDni(String dni);
    List<PersonModel> findAll();
    PersonModel save(PersonModel personModel);
    void deleteByDni(String dni);
}

