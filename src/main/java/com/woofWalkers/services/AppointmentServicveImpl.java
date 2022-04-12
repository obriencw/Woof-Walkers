package com.woofWalkers.services;

import com.woofWalkers.models.Appointment;
import com.woofWalkers.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServicveImpl implements AppointmentService{

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServicveImpl(AppointmentRepository appointmentRepository) {this.appointmentRepository = appointmentRepository;}

    @Override
    public List<Appointment> getAllAppointments() {return appointmentRepository.findAll();}

    @Override
    public void saveAppointment(Appointment appointment) {appointmentRepository.save(appointment);}

    @Override
    public Appointment getAppointmentById(long id) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        Appointment appointment = null;
        if (optional.isPresent()) {
            appointment = optional.get();
        } else {
            throw new RuntimeException("Appointment not found for id :: " + id);
        }
        return appointment;
    }

    @Override
    public void deleteAppointmentById(long id) {this.appointmentRepository.deleteById(id);}
}
