package com.example.statepublicservice.exceptionHandling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestErrorResponse {

    private String message;
    private ErrorCode errorCode;

}
