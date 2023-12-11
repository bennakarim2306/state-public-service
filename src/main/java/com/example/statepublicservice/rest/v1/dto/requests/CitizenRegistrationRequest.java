package com.example.statepublicservice.rest.v1.dto.requests;

import com.example.statepublicservice.db.models.Address;
import com.example.statepublicservice.rest.v1.dto.AddressDto;
import java.util.Date;
import lombok.Data;
import lombok.NonNull;

@Data
public class CitizenRegistrationRequest {

    @NonNull
    private String firstname;

    private String middleName;

    @NonNull
    private String surname;

    @NonNull
    private Date birthDay;

    private String phoneNumber;

    private String email;

    private byte[] imageBase64;

    @NonNull
    private AddressDto address;

    private ContactData contactData;

    record ContactData (String email, String phoneNumber) {}
}
