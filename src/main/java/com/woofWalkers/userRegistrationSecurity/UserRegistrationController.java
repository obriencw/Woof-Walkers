package com.woofWalkers.userRegistrationSecurity;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    /**
     * Returns to registration webpage if email is already registered
     * Returns to profile webpage if registration is successful
     *
     * If email is already registered, print message
     *
     * @param userDto Model Attribute of "user" is Valid UserRegistrationDto
     * @param result stores the result of validation
     * @return registration html page
     * @return profile html page
     * */
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        System.out.println(userDto.toString());

        userService.save(userDto);
        return "redirect:/profile?success";
    }

}
