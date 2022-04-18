package com.woofWalkers.controller;

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

    @Autowired
    public UsersController(UsersService usersService) {this.usersService = usersService;}

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", usersService.getAllUsers());
        return "index1";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_user";
        }
        try {
            usersService.saveUser(user);
            return "redirect:/";
        } catch (Exception e) {
            System.out.println("error incurred");
        }
        return "/emailError";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        User user = usersService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.usersService.deleteUserById(id);
        return "redirect:/allUsers";
    }

    @GetMapping("/profile")
    public String getUserDogs(Model model, Principal principal) {
        User currentUser = usersService.findByEmail(principal.getName());
        model.addAttribute("listDogs", currentUser.getDog());
        model.addAttribute("listAppointments", currentUser.getAppointment());
        return "profile";
    }

}
