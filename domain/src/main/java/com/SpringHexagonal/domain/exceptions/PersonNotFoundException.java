package com.SpringHexagonal.domain.exceptions;

public class PersonNotFoundException extends RuntimeException {

        public PersonNotFoundException(String message) {
            super(message);
        }
}
