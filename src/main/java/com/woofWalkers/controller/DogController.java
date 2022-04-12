package com.woofWalkers.controller;

import com.woofWalkers.models.Dog;
import com.woofWalkers.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class DogController {
    private DogService dogService;

    @Autowired
    public DogController(DogService dogService) {this.dogService = dogService;}

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
    public String saveDog(@ModelAttribute("dog") @Valid Dog dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_dog";
        }
        dogService.saveDog(dog);
        return "redirect:/allDogs";
    }
    @GetMapping("/showDogFormForUpdate/{id}")
    public String showDogFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        return "update_dog";
    }

    @GetMapping("/deleteDog/{id}")
    public String deleteDog(@PathVariable(value = "id") long id) {
        this.dogService.deleteDogById(id);
        return "redirect:/allDogs";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request){
//        HttpSession httpSession = request.getSession();
//        httpSession.invalidate();
//        return "logout";
//    }
}
