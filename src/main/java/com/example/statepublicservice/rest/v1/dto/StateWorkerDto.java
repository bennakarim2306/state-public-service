package com.example.statepublicservice.rest.v1.dto;

import com.example.statepublicservice.db.models.Scope;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class StateWorkerDto extends CitizenDto {

    private Scope scope;
}
