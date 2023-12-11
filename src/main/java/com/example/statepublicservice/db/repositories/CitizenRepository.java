package com.example.statepublicservice.db.repositories;

import com.example.statepublicservice.db.models.Citizen;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, String> {

    Optional<Citizen> findByFirstnameAndSurnameAndBirthDay(String firstname, String surname, Date birthDay);
}
