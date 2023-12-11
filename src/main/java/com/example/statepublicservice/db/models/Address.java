package com.example.statepublicservice.db.models;

import com.example.statepublicservice.rest.v1.dto.AddressDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(name = "unique_address", columnNames = {"street","house_number","postal_code"})})
public class Address implements Serializable {

    private static final long serialVersionUID = 2405172058950251807L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String street;
    @NonNull
    @Column(nullable = false)
    private Integer houseNumber;
    @NonNull
    @Column(nullable = false)
    private Integer postalCode;
    @NonNull
    private String city;
    private String region;

    @NonNull
    @Value("${citizen.address.country}")
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return id != null && Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void mapFromAddressDto(AddressDto addressDto) {
        this.setStreet(addressDto.getStreet());
        this.setPostalCode(addressDto.getPostalCode());
        this.setHouseNumber(addressDto.getHouseNumber());
    }
}
