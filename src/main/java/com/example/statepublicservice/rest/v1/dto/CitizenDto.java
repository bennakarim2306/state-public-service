package com.example.statepublicservice.rest.v1.dto;

import com.example.statepublicservice.db.models.Citizen;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDto {

    private String firstname;

    private String middleName;

    private String surname;

    private Integer age;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

    private String phoneNumber;

    private String email;

    private byte[] imageBase64;

    private AddressDto address;

    private List<AppointmentDto> appointments;

    public void map(Citizen citizen) {

        this.setFirstname(citizen.getFirstname());
        this.setSurname(citizen.getSurname());
        this.setBirthDay(citizen.getBirthDay());
        this.setMiddleName(citizen.getMiddleName());
        this.setEmail(citizen.getEmail());
        this.setPhoneNumber(citizen.getPhoneNumber());
    }
}
