package com.woofWalkers.services;

import com.woofWalkers.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AppointmentService {
    List<Appointment> getAllAppointments();

    Appointment saveAppointment(Appointment appointment);

    Appointment getAppointmentById(long id);

    void deleteAppointmentById(long id);

    List<Appointment> findByUsersFirstNameOrLastName(String firstNameInFix, String lastNameInfix);

    List<Appointment> findByAppointmentDateEquals(String appointmentDate);

    List<Appointment> findByCityContaining(String locationInfix);

    List<Appointment> getAllUserAppointments(long id);

}
