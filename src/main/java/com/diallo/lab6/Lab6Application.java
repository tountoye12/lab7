package com.diallo.lab6;

import com.diallo.lab6.model.Appointment;
import com.diallo.lab6.model.Dentist;
import com.diallo.lab6.model.Patient;
import com.diallo.lab6.model.Surgery;
import com.diallo.lab6.service.AppointmentService;
import com.diallo.lab6.service.DentistService;
import com.diallo.lab6.service.PatientService;
import com.diallo.lab6.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class Lab6Application implements CommandLineRunner {

	@Autowired
	private  PatientService patientService;
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	DentistService dentistService;
	@Autowired
	SurgeryService surgeryService;

	public static void main(String[] args) {

		SpringApplication.run(Lab6Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Patient gillian = new Patient(null, "P001",
				"Gillian White", null, null);

		Appointment gillian_Appointment = new Appointment(null,
				LocalDate.now(), gillian, null, null);


		Surgery surgery_S15 = new Surgery(null, "S15", null, null);


		Dentist dentist = new Dentist(null, "Tony Smith", null);
		gillian_Appointment.setPatient(gillian);
		gillian_Appointment.setSurgery(surgery_S15);
		gillian_Appointment.setDentist(dentist);

		appointmentService.saveApointment(gillian_Appointment);
	}
}
