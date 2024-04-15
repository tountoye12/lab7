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

    /*
    4. HTTP PUT request: http://localhost:8080/adsweb/api/v1/patient/update/1
    - Retrieves and updates Patient
     data for the patient whose patientId is 1 (or any other
     valid patientId). Also, make sure to
    implement appropriate exception handling,
    for where patientId is invalid and not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Integer id,
                                                 @RequestBody Patient patient) throws PatientNotFoundException {
        Patient patient1 = patientService.findPatientById(id);
        patient.setId(id);
        patient1.setFirstName(patient.getFirstName());
        patient1.setPatient_address(patient.getPatient_address());
        patient1.setPatientNumber(patient.getPatientNumber());
        patient1.setAppointments(patient.getAppointments());
        return ResponseEntity.ok(patient1);
    }

    /*
    5. HTTP DELETE request: http://localhost:8080/adsweb/api/v1/patient/delete/1 -
    Deletes the Patient data for the patient
    whose patientId is 1 (or any other valid patientId).
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") Integer id) throws PatientNotFoundException {
        Patient patient = patientService.findPatientById(id);
        System.out.println("###########################");
        System.out.println(patient);
        System.out.println("###########################");
        Patient patient1 = patientService.deletePatient(patient);
        return ResponseEntity.ok(patient1);
    }


}

