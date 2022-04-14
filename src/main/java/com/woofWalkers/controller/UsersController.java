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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {this.usersService = usersService;}

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", usersService.getAllUsers());
        return "index";
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
//        usersService.saveUser(user);

//        if (user.getId()!=null) {
//            return "redirect:/";
//        } else {
//            return "redirect:/showNewUserForm";
//        }
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
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "logout";
    }
}
