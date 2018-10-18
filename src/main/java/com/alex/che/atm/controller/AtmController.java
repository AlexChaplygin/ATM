package com.alex.che.atm.controller;

import com.alex.che.atm.entity.Card;
import com.alex.che.atm.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class AtmController {

    private CardService cardService;

    @GetMapping
    public ModelAndView indexRedirect() {
        return new ModelAndView("redirect:/index.html");
    }

    @GetMapping("/card-number/{number}")
    public ModelAndView checkCardNumber(@PathVariable String number) {

        Card card = cardService.findCardByCardNumber(number);

        if (card != null) {
            return new ModelAndView("redirect:/pin.html");
        }

        return new ModelAndView("card", Collections.singletonMap("message", "Card doesn't exist."), HttpStatus.NOT_FOUND);
    }
}
