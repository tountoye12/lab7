package com.diallo.lab7.service;


import com.diallo.lab7.exception.PatientNotFoundException;
import com.diallo.lab7.model.Patient;
import com.diallo.lab7.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    public  PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(Integer id) throws PatientNotFoundException {

        Patient patient = patientRepository.findPatientById(id);
        if(patient == null)
            throw new PatientNotFoundException("Patient not found");

        else
            return patient;
    }

    public Patient deletePatient(Patient patient) {
        Patient deletedPatient = patientRepository.findPatientById(patient.getId());
        patientRepository.delete(patient);
        return deletedPatient;
    }

    public List<Patient> findByFirstName(String searchString) {
        System.out.println("searchString: " + searchString);
        return patientRepository.findPatientByFirstName(searchString);
    }
}
