package com.andreiDumitriu.Kitesurfing.controllers;


import com.andreiDumitriu.Kitesurfing.UserValidator;
import com.andreiDumitriu.Kitesurfing.model.User;
import com.andreiDumitriu.Kitesurfing.repositories.UserRepository;
import com.andreiDumitriu.Kitesurfing.services.SecurityService;
import com.andreiDumitriu.Kitesurfing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    private final UserRepository repository;

    UserController(UserRepository rep){
        this.repository = rep;
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userForm",new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
        userValidator.validate(userForm,bindingResult);

        if(bindingResult.hasErrors()){
            return "signup";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(),userForm.getPasswordConfirmation());

        return "redirect:/welcome";

    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(!(auth instanceof AnonymousAuthenticationToken)){
            String userName=auth.getName();

            return userName;
        }

        if (error != null){
            model.addAttribute("error","Your username and password is invalid");
        }

        if (logout != null){
            model.addAttribute("message","You have been logged out successfully!");
        }

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }


}
