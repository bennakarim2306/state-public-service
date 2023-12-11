package com.example.statepublicservice.db.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Indexed;

@Entity
@Indexed()
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Appointment implements Serializable {

    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @OneToOne
    @JoinColumn(name = "initiator_id")
    private StateWorker initiator;

    private Date dateOfCreation;

    private Date dateOfDue;

    private AppointmentSubject subject;

    private String comment;

    public StateWorker getInitiator() {
        return initiator;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Appointment that = (Appointment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}