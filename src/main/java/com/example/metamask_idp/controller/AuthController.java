package com.example.metamask_idp.controller;

import com.example.metamask_idp.dto.MetamaskAuthRequest;
import com.example.metamask_idp.service.KeycloakService;
import com.example.metamask_idp.service.MetaMaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

  @Autowired
  private MetaMaskService metamaskService;

  @Autowired
  private KeycloakService keycloakService;

  @PostMapping("/auth/metamask")
  public String authenticateMetamask(@RequestBody MetamaskAuthRequest authRequest, Model model) {
    if (metamaskService.verifySignature(authRequest.getAddress(), authRequest.getSignature(),
        authRequest.getMessage())) {
      String token = keycloakService.authenticateWithKeycloak(authRequest.getAddress());
      model.addAttribute("token", token);
      return "redirect:/home";
    } else {
      return "redirect:/login?error";
    }
  }

  @GetMapping("/home")
  public String home(OAuth2AuthenticationToken authentication, Model model) {
    OAuth2User user = authentication.getPrincipal();
    model.addAttribute("user", user.getAttributes());
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
