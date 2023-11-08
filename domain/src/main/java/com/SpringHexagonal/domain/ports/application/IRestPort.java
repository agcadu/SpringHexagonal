package com.SpringHexagonal.domain.ports.application;

import com.SpringHexagonal.domain.model.PersonDomain;

public interface IRestPort {

    PersonDomain getPerson(String dni);
}
