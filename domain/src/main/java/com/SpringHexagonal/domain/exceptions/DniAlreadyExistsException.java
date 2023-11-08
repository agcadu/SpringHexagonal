package com.SpringHexagonal.domain.exceptions;

public class DniAlreadyExistsException extends RuntimeException{

        public DniAlreadyExistsException(String message) {
            super(message);
        }
}
