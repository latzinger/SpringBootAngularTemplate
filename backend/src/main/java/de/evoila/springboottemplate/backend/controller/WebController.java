package de.evoila.springboottemplate.backend.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookstore")
public class WebController {

    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    public ModelAndView login(KeycloakAuthenticationToken keycloakAuthenticationToken) {

        ModelAndView modelAndView = new ModelAndView("index");

        KeycloakSecurityContext context = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext();
        modelAndView.addObject("realm", context.getRealm());
        modelAndView.addObject("token", "Bearer " + context.getTokenString());

        return modelAndView;
    }

}
