package com.example.statepublicservice.rest.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class AddressDto {

    private String street;
    private String city;
    private Integer houseNumber;
    private Integer postalCode;
    private String country;
    private String region;
}
