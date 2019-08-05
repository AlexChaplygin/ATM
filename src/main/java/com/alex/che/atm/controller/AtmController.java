package com.alex.che.atm.controller;

import com.alex.che.atm.model.CardLoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class AtmController {

    @GetMapping
    public ModelAndView main(Model model) {
        return new ModelAndView("redirect:/number.html");
    }

    @GetMapping(value = "/card-number")
    public ResponseEntity<String> enterCardNumber(@RequestParam String number) {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @PostMapping(value = "/card-pin")
    public ResponseEntity<String> enterCardPin(@RequestBody CardLoginRequest cardLoginRequest) {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}
