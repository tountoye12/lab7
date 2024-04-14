package com.diallo.lab6.repository;

import com.diallo.lab6.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository  extends JpaRepository<Dentist, Long> {


}
