package com.woofWalkers.controller;

import com.woofWalkers.services.AppointmentService;
import com.woofWalkers.userRegistrationSecurity.User;
import com.woofWalkers.services.UsersService;
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

@Controller
public class UsersController {
    private UsersService usersService;
    private AppointmentService appointmentService;

    @Autowired
    public UsersController(UsersService usersService, AppointmentService appointmentService) {this.usersService = usersService;
        this.appointmentService = appointmentService;
    }

    // handler method for viewing all registered users
    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", usersService.getAllUsers());
        return "index1";
    }

    // handler method for registering a new user
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    // handler method for saving a user
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_user";
        }
        try {
            usersService.saveUser(user);
            return "redirect:/allUsers";
        } catch (Exception e) {
            System.out.println("error incurred");
        }
        return "/allUsers";
    }

    // handler method for updating a user's information by id
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        User user = usersService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    // handler method for deleting a user
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.usersService.deleteUserById(id);
        return "redirect:/allUsers";
    }

    // handler method for viewing a user's profile
    // displays user's dog(s) and user's appointment(s)
    @GetMapping("/profile")
    public String getUserDogs(Model model, Principal principal) {
        User currentUser = usersService.findByEmail(principal.getName());
        model.addAttribute("listDogs", currentUser.getDog());
        model.addAttribute("listAppointments", appointmentService.getAllUserAppointments(currentUser.getId()));
        return "profile";
    }

}
