package com.example.statepublicservice.rest.v1.dto;


import com.example.statepublicservice.db.models.AppointmentSubject;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private CitizenDto citizen;

    private StateWorkerDto initiator;

    private Date dateOfCreation;

    private Date dateOfDue;

    private AppointmentSubject subject;

    private String comment;

}
