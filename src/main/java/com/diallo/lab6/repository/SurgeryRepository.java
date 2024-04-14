package com.diallo.lab6.repository;

import com.diallo.lab6.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
