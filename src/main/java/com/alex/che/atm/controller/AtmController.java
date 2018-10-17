package com.alex.che.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AtmController {

    @GetMapping
    public ModelAndView indexRedirect(ModelMap model) {
        return new ModelAndView("redirect:/index.html", model);
    }
}
