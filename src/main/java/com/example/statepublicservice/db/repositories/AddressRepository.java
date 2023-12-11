package com.example.statepublicservice.db.repositories;

import com.example.statepublicservice.db.models.Address;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    public Optional<Address> findByStreetAndPostalCodeAndHouseNumber(String street, Integer postalCode, Integer houseNumber);
}
