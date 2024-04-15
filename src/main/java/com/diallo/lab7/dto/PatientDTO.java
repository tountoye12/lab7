package com.diallo.lab7.dto;

import com.diallo.lab7.model.Address;
import com.diallo.lab7.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private String patientNumber;
    private String firstName;
    private Address patient_address;
    private List<Appointment> appointments;
}
