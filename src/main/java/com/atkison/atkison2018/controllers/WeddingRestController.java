package com.atkison.atkison2018.controllers;

import com.atkison.atkison2018.models.Reserved;
import com.atkison.atkison2018.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class WeddingRestController {
    @Autowired
    private ReserveService reserveService;

    public WeddingRestController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }
}
