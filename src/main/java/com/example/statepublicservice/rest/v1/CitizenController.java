package com.example.statepublicservice.rest.v1;

import com.example.statepublicservice.db.models.Citizen;
import com.example.statepublicservice.rest.v1.dto.CitizenDto;
import com.example.statepublicservice.rest.v1.dto.requests.CitizenRegistrationRequest;
import com.example.statepublicservice.service.CitizenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/citizen", "/citizens"})
@AllArgsConstructor
@Slf4j
public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping("/personalized/{userId}")
    public CitizenDto getCitizen(@PathVariable String userId){
        return new CitizenDto();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CitizenDto registerCitizen(@RequestBody CitizenRegistrationRequest citizenRegistrationRequest) {
        log.info("received post request to add citizen {}",  citizenRegistrationRequest);
        return citizenService.registerNewCitizen(citizenRegistrationRequest);
    }

}
