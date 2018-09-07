package com.atkison.atkison2018.controllers;

import com.atkison.atkison2018.models.Reserved;
import com.atkison.atkison2018.repository.ReserveRepository;
import com.atkison.atkison2018.services.ReserveService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class WeddingController {

    @Autowired
    private ReserveService reserveService;

    public WeddingController(ReserveService reserveService)
    {
        reserveService = reserveService;
    }

    @GetMapping("/")
    public ModelAndView MainView(Model model, RedirectAttributes redirectAttributes)
    {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("reserved", new Reserved());
        mv.setViewName("Main");

        return mv;
    }

    @PostMapping("/")
    public String NewRSVP(@Valid @ModelAttribute("reserved") Reserved reserved, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {
        if(bindingResult.hasErrors())
        {

        }
        this.reserveService.addNewReservation(reserved);
        redirectAttributes.addFlashAttribute("message", "You have successfully Reserved your spot!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView DashboardView(Model model)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Dashboard");

        return mv;
    }
}
