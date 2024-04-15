package com.diallo.lab7.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    private String state;
    private String zip;

    @OneToOne(mappedBy = "patient_address", cascade = CascadeType.ALL)
    private Patient patient;
    @OneToOne(mappedBy = "surgery_address", cascade = CascadeType.ALL)
    private Surgery surgery;


}