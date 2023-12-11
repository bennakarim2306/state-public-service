package com.example.statepublicservice.service;


import com.example.statepublicservice.db.models.Address;
import com.example.statepublicservice.db.models.Citizen;
import com.example.statepublicservice.db.repositories.AddressRepository;
import com.example.statepublicservice.db.repositories.CitizenRepository;
import com.example.statepublicservice.rest.v1.dto.AddressDto;
import com.example.statepublicservice.rest.v1.dto.CitizenDto;
import com.example.statepublicservice.rest.v1.dto.requests.CitizenRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    private final AddressRepository addressRepository;

    public CitizenService(CitizenRepository citizenRepository, AddressRepository addressRepository) {
        this.citizenRepository = citizenRepository;
        this.addressRepository = addressRepository;
    }

    public CitizenDto registerNewCitizen(CitizenRegistrationRequest citizenRegistrationRequest) {
        Citizen citizen = citizenRepository.findByFirstnameAndSurnameAndBirthDay(citizenRegistrationRequest.getFirstname(),citizenRegistrationRequest.getSurname(),citizenRegistrationRequest.getBirthDay()).orElse(null);
        CitizenDto citizenDto = new CitizenDto();
        if(citizen != null) {
            citizenDto.map(citizen);
            return citizenDto;
        } else {
            citizen = new Citizen();
        }

        AddressDto address = citizenRegistrationRequest.getAddress();
        Address addressFromDB = addressRepository.findByStreetAndPostalCodeAndHouseNumber(address.getStreet(), address.getPostalCode(), address.getHouseNumber()).orElse(null);
        if (addressFromDB == null) {
            addressFromDB = new Address();
            addressFromDB.mapFromAddressDto(address);
        }
        citizen.setAddress(addressFromDB);
        citizen.mapFromCitizenRequest(citizenRegistrationRequest);
        addressRepository.save(addressFromDB);
        citizenRepository.save(citizen);
        log.debug("citizen added to data base {}", citizen);
        citizenDto.map(citizen);
        return citizenDto;
    }
}
