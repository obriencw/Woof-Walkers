package com.woofWalkers.controller;

import com.woofWalkers.models.Appointment;
import com.woofWalkers.models.Dog;
import com.woofWalkers.services.AppointmentService;
import com.woofWalkers.services.DogService;
import com.woofWalkers.services.UsersService;
import com.woofWalkers.userRegistrationSecurity.User;
import com.woofWalkers.userRegistrationSecurity.UserService;
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
import java.util.Set;

@Controller
public class DogController {
    private DogService dogService;
    private UsersService usersService;
    private AppointmentService appointmentService;

    @Autowired
    public DogController(DogService dogService, UsersService usersService, AppointmentService appointmentService) {this.dogService = dogService;
        this.usersService = usersService; this.appointmentService = appointmentService;
    }

    @GetMapping("/allDogs")
    public String getAllDogs(Model model) {
        model.addAttribute("listDogs", dogService.getAllDogs());
        return "allDogs";
    }

    @GetMapping("/showNewDogForm")
    public String showNewDogForm(Model model) {
        Dog dog = new Dog();
        model.addAttribute("dog", dog);
        return "new_dog";
    }

    @PostMapping("/saveDog")
    public String saveDog(@ModelAttribute("dog") @Valid Dog dog, BindingResult bindingResult, Principal principal) {
        User currentUser = usersService.findByEmail(principal.getName());
        if (bindingResult.hasErrors()) {
            return "new_dog";
        }
        Dog saveDog = dogService.saveDog(dog);
        currentUser.getDog().add(saveDog);
        usersService.saveUser(currentUser);
        return "redirect:/profile";
    }
    @GetMapping("/showDogFormForUpdate/{id}")
    public String showDogFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        return "update_dog";
    }

    @GetMapping("/adminShowDogFormForUpdate/{id}")
    public String adminShowDogFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        return "admin_update_dog";
    }

    @GetMapping("/deleteDog/{id}")
    public String deleteDog(@PathVariable(value = "id") long id, Principal principal) {
        User user = usersService.findByEmail(principal.getName());
        Set<Dog> dog = user.getDog();
        Dog dog1 = dogService.getDogById(id);
        dog.remove(dog1);
        usersService.saveUser(user);
        this.dogService.deleteDogById(id);
        return "redirect:/profile";
    }

}
