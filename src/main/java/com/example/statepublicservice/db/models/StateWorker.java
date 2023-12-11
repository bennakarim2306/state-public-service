package com.example.statepublicservice.db.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StateWorker extends Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Scope scope;

}
