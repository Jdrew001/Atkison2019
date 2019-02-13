package com.atkison.atkison2018.controllers;

import com.atkison.atkison2018.models.Reserved;
import com.atkison.atkison2018.services.EmailService;
import com.atkison.atkison2018.services.IpAddressService;
import com.atkison.atkison2018.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class WeddingController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private IpAddressService ipAddressService;

    @Autowired
    private EmailService emailService;

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
    public String NewRSVP(@Valid @ModelAttribute("reserved") Reserved reserved, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request)
    {
        if(bindingResult.hasErrors())
        {
            redirectAttributes.addFlashAttribute("message", "Uh Oh, something went wrong!");
            redirectAttributes.addFlashAttribute("alertClass", "danger");
        }
        this.reserveService.addNewReservation(reserved, request.getRemoteAddr());
        this.ipAddressService.saveIpAddress(request.getRemoteAddr(), reserved);


        try {
            this.emailService.sendSimpleMessage("dtatkison@gmail.com", "ATKISON2019-WeddingRSVP", "Reservation: \n\n"
                    + reserved.getFirstname() + " " + reserved.getLastname() + " \nNumber in party going to ceremony: " + reserved.getPartyNumberCeremony()
                    + " \nNumber in party going to reception: " + reserved.getPartyNumberReception());
        } catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        redirectAttributes.addFlashAttribute("message", "You have successfully Reserved your spot!");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView DashboardView(Model model)
    {
        List<Reserved> reserveds = reserveService.getAllReservations();
        model.addAttribute("reserved", new Reserved());
        //number of guests going to ceremony
        int guestsCeremony = 0;
        int guestsReception = 0;
        int numOfParties = 0;

        for (Reserved r: reserveds) {
            try {
                guestsCeremony += Integer.parseInt(r.getPartyNumberCeremony());
                guestsReception += Integer.parseInt(r.getPartyNumberReception());

                numOfParties += 1;
            } catch(Exception ex) {
                System.out.println(ex.getLocalizedMessage());
                break;
            }
        }

        ModelAndView mv = new ModelAndView();
        model.addAttribute("reservations", reserveds);
        model.addAttribute("guestCeremony", guestsCeremony);
        model.addAttribute("guestReception", guestsReception);
        model.addAttribute("numOfParties", numOfParties);
        mv.setViewName("Dashboard");

        return mv;
    }

    @PostMapping(value = "/dashboard/delete/")
    public String RemoveReservation(@Valid @ModelAttribute("reserved") Reserved reserved, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(reserved.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "Uh Oh, something went wrong!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        } else {
            try {
                reserveService.deleteReservation(reserved.getId());
            } catch (Exception ex) {
                redirectAttributes.addFlashAttribute("message", "Uh Oh, something went wrong!");
                redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

                return "redirect:/dashboard";
            }

            redirectAttributes.addFlashAttribute("message", "RSVP Successfully delete!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        }

        return "redirect:/dashboard";
    }
}


























