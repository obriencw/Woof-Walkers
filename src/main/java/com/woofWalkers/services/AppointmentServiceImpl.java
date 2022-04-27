package com.woofWalkers.services;

import com.woofWalkers.models.Appointment;
import com.woofWalkers.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        }

    @Override
    public List<Appointment> getAllAppointments() {return appointmentRepository.findAll();}

    @Override
    public Appointment saveAppointment(Appointment appointment) {return appointmentRepository.save(appointment);}

    /**
     * Returns an Appointment object based on id argument
     *
     * If no appointment found for given id, print message
     *
     * @param id id of an appointment
     * @return Appointment object
     * */
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

    @Override
    public List<Appointment> findByUsersFirstNameOrLastName(String firstNameInFix, String lastNameInfix) {
        return appointmentRepository.findByUserFirstNameOrUserLastNameContaining(firstNameInFix, lastNameInfix);
    }

    @Override
    public  List<Appointment> findByAppointmentDateEquals(String appointmentDate) {
        return appointmentRepository.findByAppointmentDateEquals(appointmentDate);
    }

    @Override
    public  List<Appointment> findByCityContaining(String locationInfix) {
        return appointmentRepository.findByUserCityContaining(locationInfix);
    }

    @Override
    public List<Appointment> getAllUserAppointments(long id) {
        return appointmentRepository.findByUserId(id);
    }


}
