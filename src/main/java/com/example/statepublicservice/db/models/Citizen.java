package com.example.statepublicservice.db.models;

import com.example.statepublicservice.constraints.AddressAnnotation;
import com.example.statepublicservice.constraints.Email;
import com.example.statepublicservice.constraints.PhoneNumber;
import com.example.statepublicservice.rest.v1.dto.requests.CitizenRegistrationRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "citizens")
@Table(indexes = {@Index(columnList = "firstname"), @Index(columnList = "surname"), @Index(columnList = "birth_day")}, uniqueConstraints = {@UniqueConstraint(name = "citizen_unique", columnNames = {"firstname", "surname", "birth_day"})})
@NoArgsConstructor
public class Citizen implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    private String firstname;

    private String middleName;

    @NonNull
    private String surname;

    @NonNull
    @DateTimeFormat
    private Date birthDay;

    @PhoneNumber
    private String phoneNumber;

    @Email
    private String email;

    private byte[] imageBase64;

    private Date registrationDate;

    @AddressAnnotation
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE})
    @JoinColumns(value = {@JoinColumn(referencedColumnName = "houseNumber"), @JoinColumn(referencedColumnName = "postalCode"), @JoinColumn(referencedColumnName = "street")})
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "citizen")
    private List<Appointment> appointmentList = new java.util.ArrayList<>();

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Citizen citizen = (Citizen) o;
        return id != null && Objects.equals(id, citizen.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void mapFromCitizenRequest(CitizenRegistrationRequest citizenRegistrationRequest) {
        this.setFirstname(citizenRegistrationRequest.getFirstname());
        this.setSurname(citizenRegistrationRequest.getSurname());
        this.setMiddleName(citizenRegistrationRequest.getMiddleName());
        this.setEmail(citizenRegistrationRequest.getEmail());
        this.setPhoneNumber(citizenRegistrationRequest.getPhoneNumber());
        this.setBirthDay(citizenRegistrationRequest.getBirthDay());
    }

    @PrePersist
    private void initRegistrationDate() {
        this.registrationDate = new Date();
    }
}
