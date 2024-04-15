package com.diallo.lab7.controller;


import com.diallo.lab7.exception.PatientNotFoundException;
import com.diallo.lab7.model.Patient;
import com.diallo.lab7.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adsweb/api/v1/patient")
public class PatientController {

    private  PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    /*
    1. HTTP GET request: http://localhost:8080/adsweb/api/v1/patient/list -
        Displays the list of all Patients,
        including their primaryAddresses, sorted in ascending
        order by their lastName, in JSON format.
     */
    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getAllPatients() {
       return ResponseEntity.ok(patientService.getAllPatient());
    }

    /*
    3. HTTP POST request: http://localhost:8080/adsweb/api/v1/patient/register - Register a new Patient
    into the system.
    Note: You supply the correct/appropriate Patient data in JSON format
     */

    @PostMapping("/register")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return ResponseEntity.ok(patient);
    }

    /*
    HTTP GET request: http://localhost:8080/adsweb/api/v1/patient/get/1 - Displays the data for Patient
    whose PatientId is 1 including the primaryAddress, in JSON format. Also, make sure to
    implement appropriate exception handling, for where patientId is invalid and not found.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id")  Integer id) throws PatientNotFoundException {
        Patient patient = patientService.findPatientById(id);
        return ResponseEntity.ok(patient);
    }


}

