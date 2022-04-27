package com.woofWalkers.controller;

import com.woofWalkers.models.Appointment;
import com.woofWalkers.models.QueryObj;
import com.woofWalkers.services.AppointmentService;
import com.woofWalkers.services.UsersService;
import com.woofWalkers.userRegistrationSecurity.User;
import com.woofWalkers.userRegistrationSecurity.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;
    private UsersService usersService;


    @Autowired
    public AppointmentController(AppointmentService appointmentService, UsersService usersService) {
        this.appointmentService = appointmentService;
        this.usersService = usersService;}

    // handler method for viewing all appointments and custom queries for searching appointments
    @GetMapping("/allAppointments")
    public String getAllAppointments(Model model) {
        model.addAttribute("listAppointments", appointmentService.getAllAppointments());
        model.addAttribute("queryObj", new QueryObj());
        return "allAppointments";
    }

    // handler method for new appointment form
    @GetMapping("/showNewAppointmentForm")
    public String showNewAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "new_appointment";
    }

    // handler method for saving an appointment
    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") @Valid Appointment appointment, BindingResult bindingResult, Principal principal) {
        User currentUser = usersService.findByEmail(principal.getName());
        if (bindingResult.hasErrors()) {
            return "new_appointment";
        }
        appointment.setUser(currentUser);
        Appointment saveAppointment = appointmentService.saveAppointment(appointment);

        return "redirect:/profile";
    }

    // handler method for updating an appointment
    @GetMapping("/showAppointmentFormForUpdate/{id}")
    public String showAppointmentFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "update_appointment";
    }

    // handler method for updating appointment form for admin
    @GetMapping("/adminShowAppointmentFormForUpdate/{id}")
    public String adminShowAppointmentFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "admin_update_appointment";
    }

    // handler method for deleting an appointment
    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable(value = "id") long id) {
        this.appointmentService.deleteAppointmentById(id);
        return "redirect:/profile";
    }

    // handler method for finding appointment(s) using custom queries
    @PostMapping("/findAppointments")
    public String findAppointment(@ModelAttribute QueryObj queryObj, Model model) {

        Set<Appointment> appointmentSet = new HashSet<>();

        if(!queryObj.getQueryName().isEmpty()) {
            String name = queryObj.getQueryName();
            appointmentSet.addAll(appointmentService.findByUsersFirstNameOrLastName(name, name));
        }

        if(!queryObj.getQueryCity().isEmpty()) {
            appointmentSet.addAll(appointmentService.findByCityContaining(queryObj.getQueryCity()));
        }

        if(queryObj.getQueryAppointmentDate() != null) {
            appointmentSet.addAll(appointmentService.findByAppointmentDateEquals(queryObj.getQueryAppointmentDate()));
        }

        model.addAttribute("listAppointments", appointmentSet);
        model.addAttribute("userRegistrationDto", new UserRegistrationDto());

        return  "allAppointments";
    }
}
