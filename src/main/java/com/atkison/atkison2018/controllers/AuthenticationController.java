package com.atkison.atkison2018.controllers;

import com.atkison.atkison2018.models.User;
import com.atkison.atkison2018.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView LoginView(Model model)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login");

        return mv;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView RegistrationView(Model model)
    {
        return new ModelAndView("Registration", "user", new User());
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView RegistrationView(@ModelAttribute User user, BindingResult result, ModelMap model)
    {
        ModelAndView mv = new ModelAndView();
        User userExisits = userService.findUserByEmail(user.getEmail());

        if(userExisits != null)
            result.reject("Authentication error exists.");
        else
        {
            userService.saveUser(user);
            mv.addObject("successMessage", "User has been registered successfully");
            //set the next view here
            mv.setViewName("Main");
        }

        return mv;
    }
}
