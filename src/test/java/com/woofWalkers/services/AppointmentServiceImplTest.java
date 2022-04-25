package com.woofWalkers.services;

import com.woofWalkers.models.Appointment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentServiceImplTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    void getAllAppointments() {
        List<Appointment> allAppointments = appointmentService.getAllAppointments();
        int beforeAddingMoreAppointments = allAppointments.size();

        Appointment appointment1 = new Appointment();
        appointment1.setAppointmentDate("6/12/2022");
        appointment1.setAppointmentTime("11:00");
        appointmentService.saveAppointment(appointment1);
        int afterAddingMoreAppointments = appointmentService.getAllAppointments().size();

        Assertions.assertThat(afterAddingMoreAppointments).isEqualTo(beforeAddingMoreAppointments + 1);
        Assertions.assertThat(allAppointments.contains(appointment1));
    }
}
