package com.diallo.lab6.service;


import com.diallo.lab6.model.Surgery;
import com.diallo.lab6.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

@Service

public class SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
    public Surgery save(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
