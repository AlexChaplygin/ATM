package com.alex.che.atm.controller;

import com.alex.che.atm.dto.CardDTO;
import com.alex.che.atm.exception.ThereIsNoSuchCardException;
import com.alex.che.atm.model.CardLoginRequest;
import com.alex.che.atm.service.BusinessOperationsService;
import com.alex.che.atm.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
@SessionAttributes(types = CardLoginRequest.class)
public class AtmController {

    private CardService cardService;
    private BusinessOperationsService businessOperationsService;

    public AtmController(CardService cardService,
                         BusinessOperationsService businessOperationsService) {
        this.cardService = cardService;
        this.businessOperationsService = businessOperationsService;
    }

    @GetMapping
    public ModelAndView main(Model model) {
        model.addAttribute(new CardLoginRequest());
        return new ModelAndView("redirect:/number.html");
    }

    @PostMapping(value = "/card-number")
    public ModelAndView enterCardNumber(@RequestBody CardLoginRequest cardLoginRequest) {
        CardDTO cardDTO = cardService.findCardByNumber(cardLoginRequest.getNumber());
        if (cardDTO == null) {
            throw new ThereIsNoSuchCardException();
        }
//        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        return new ModelAndView("redirect:/pin.html");
    }

    @GetMapping("/balance/{number}")
    public ResponseEntity<CardDTO> getBalance(@PathVariable String number){
        return ResponseEntity.ok(businessOperationsService.getBalance(number));
    }

    @GetMapping("/withdrawal/{number}/{amount}")
    public ResponseEntity<String> getMoney(@PathVariable String number, @PathVariable String amount){
        businessOperationsService.withdrawMoney(number, amount);
        return ResponseEntity.ok("Ok");
    }

}
