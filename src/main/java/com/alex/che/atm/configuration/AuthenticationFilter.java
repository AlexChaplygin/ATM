package com.alex.che.atm.configuration;

import com.alex.che.atm.dto.CardDTO;
import com.alex.che.atm.exception.CardIsBlockedException;
import com.alex.che.atm.exception.WrongPinException;
import com.alex.che.atm.model.LoginModel;
import com.alex.che.atm.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private CardService cardService;
    private LoginModel loginModel;
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(CardService cardService, AuthenticationManager authenticationManager) {
        this.cardService = cardService;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            loginModel = new ObjectMapper().readValue(request.getInputStream(), LoginModel.class);
            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(loginModel.getNumber(), loginModel.getPin(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        String cardNumber = loginModel.getNumber();

        CardDTO cardDTO = cardService.findCardByNumber(cardNumber);
        if (cardDTO.getIsBlocked()) {
            failed = new CardIsBlockedException("Your card is blocked");
        } else {
            if (cardDTO.getWrongAttempts() < 4) {
                Long attempts = cardDTO.getWrongAttempts();
                cardDTO.setWrongAttempts(attempts + 1);
                cardService.saveCard(cardDTO);
                failed = new WrongPinException("Wrong pin. You have " + (4 - cardDTO.getWrongAttempts()) + " attempts");
            } else {
                cardDTO.setIsBlocked(true);
                cardService.saveCard(cardDTO);
                failed = new CardIsBlockedException("You entered the wrong pin-code for three times. Your card is blocked.");
            }
        }
        super.unsuccessfulAuthentication(request, response, failed);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String cardNumber = ((User) authResult.getPrincipal()).getUsername();
        CardDTO cardDTO = cardService.findCardByNumber(cardNumber);
        cardDTO.setWrongAttempts(0L);
        cardService.saveCard(cardDTO);

        String token = Jwts.builder()
                .setSubject(cardDTO.getNumber())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong("1200000")))
                .signWith(SignatureAlgorithm.HS512, "H434HY4HJHJ897FFF")
                .compact();
        response.addHeader("token", "Bearer " + token);
        response.addHeader("cardNumber", cardDTO.getNumber());
    }

}
