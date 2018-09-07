package com.atkison.atkison2018.controllers;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeddingController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView MainView(Model model)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Main");

        return mv;
    }

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView DashboardView(Model model)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Dashboard");

        return mv;
    }
}
