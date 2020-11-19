package de.evoila.springboottemplate.backend.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/bookstore")
public class WebController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView login(Principal principal) {

        ModelAndView modelAndView = new ModelAndView("index");

        KeycloakPrincipal<KeycloakSecurityContext> keycloakPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;

        KeycloakSecurityContext context = keycloakPrincipal.getKeycloakSecurityContext();

        String realm = context.getRealm();
        String token = context.getTokenString();
        String idToken = context.getIdTokenString();
        String accessToken = context.getToken().toString();

        modelAndView.addObject("realm", realm);
        modelAndView.addObject("token", token);

        return modelAndView;
    }

}
