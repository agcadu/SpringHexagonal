package com.SpringHexagonal.adapter_rest.controller.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;

}

