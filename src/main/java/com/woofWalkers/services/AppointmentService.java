package com.woofWalkers.services;

import com.woofWalkers.models.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    void saveAppointment(Appointment appointment);

    Appointment getAppointmentById(long id);

    void deleteAppointmentById(long id);
}