package com.woofWalkers.repository;

import com.woofWalkers.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findAppointmentById(Long id);
    List<Appointment> findByUserFirstNameOrUserLastNameContaining(String firstNameInFix, String lastNameInfix);
    List<Appointment> findByAppointmentDateEquals(String appointmentDate);
    List<Appointment> findByUserCityContaining(String locationInfix);
    List<Appointment> findByUserId(long id);
}
