package com.atkison.atkison2018.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}
