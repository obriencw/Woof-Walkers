package com.woofWalkers.repositories;

import com.woofWalkers.models.Appointment;
import com.woofWalkers.repository.AppointmentRepository;
import com.woofWalkers.services.AppointmentService;
import com.woofWalkers.userRegistrationSecurity.User;
import com.woofWalkers.userRegistrationSecurity.UserRepository;
import com.woofWalkers.userRegistrationSecurity.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void findByAppointmentDateContainingShouldReturnCorrectResult() {
        List<Appointment> beforeList = appointmentRepository.findByAppointmentDateEquals("4/25/2022");
        int beforeAddingMoreAppointments = beforeList.size();

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate("4/25/2022");
        appointment.setAppointmentTime("11:00");

        appointmentService.saveAppointment(appointment);

        List<Appointment> resultList = appointmentRepository.findByAppointmentDateEquals("4/25/2022");

        Assertions.assertThat(resultList.size()).isEqualTo(beforeAddingMoreAppointments + 1);
        Assertions.assertThat(resultList.contains(appointment)).isTrue();
    }
}
