package com.valery.Site.Web.Controllers;


import com.valery.Site.Autentification.UserValidator;
import com.valery.Site.Entities.User;
import com.valery.Site.Service.SecurityService;
import com.valery.Site.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    UserValidator userValidator;

    @RequestMapping(value = "/registration" , method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm",model);
        return "registration";
    }

    @RequestMapping(value = "/registration" , method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(),userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error!= null) {
            model.addAttribute("error","Password or/and Login - incorrect");
        }
        if(logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"} , method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
