package com.woofWalkers.controller;

import com.woofWalkers.models.Appointment;
import com.woofWalkers.models.Dog;
import com.woofWalkers.services.AppointmentService;
import com.woofWalkers.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {this.appointmentService = appointmentService;}

    @GetMapping("/allAppointments")
    public String getAllAppointments(Model model) {
        model.addAttribute("listAppointments", appointmentService.getAllAppointments());
        return "allAppointments";
    }

    @GetMapping("/showNewAppointmentForm")
    public String showNewAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "new_appointment";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") @Valid Appointment appointment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_appointment";
        }
        appointmentService.saveAppointment(appointment);
        return "redirect:/allAppointments";
    }
    @GetMapping("/showAppointmentFormForUpdate/{id}")
    public String showAppointmentFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        return "update_appointment";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable(value = "id") long id) {
        this.appointmentService.deleteAppointmentById(id);
        return "redirect:/allAppointments";
    }
}
