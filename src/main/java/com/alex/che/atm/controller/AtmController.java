package com.alex.che.atm.controller;

import com.alex.che.atm.entity.Card;
import com.alex.che.atm.model.CardRequestModel;
import com.alex.che.atm.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class AtmController {

    private CardService cardService;

    @GetMapping
    public ModelAndView indexRedirect() {
        return new ModelAndView("redirect:/index.jsp");
    }

    @PostMapping("/card-number")
    public ModelAndView checkCardNumber(@RequestBody CardRequestModel cardRequestModel) {

        Card card = cardService.findCardByCardNumber(cardRequestModel.getCardNumber());

        if (card != null) {
            return new ModelAndView("redirect:/pin");
        }

        return new ModelAndView("redirect:/index", Collections.singletonMap("message", "Card doesn't exist."), HttpStatus.NOT_FOUND);
    }
}
