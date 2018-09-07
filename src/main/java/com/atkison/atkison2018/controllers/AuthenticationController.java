package com.atkison.atkison2018.controllers;

import com.atkison.atkison2018.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AuthenticationController
{

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView LoginView(Model model)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login");

        return mv;
    }

    @RequestMapping(value = {"/loginfailure"}, method = RequestMethod.POST)
    public ModelAndView LoginFailure(Model model)
    {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("error", new String("Your login attempt is unsuccessful"));
        mv.setViewName("Login");

        return mv;
    }
}
