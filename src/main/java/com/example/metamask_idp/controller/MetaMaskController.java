package com.example.metamask_idp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Controller
public class MetaMaskController {

  @GetMapping("/loginSuccess")
  public String getLoginInfo(Model model, @AuthenticationPrincipal OidcUser principal) {
    model.addAttribute("name", principal.getName());
    model.addAttribute("email", principal.getEmail());
    return "loginSuccess";
  }

  @GetMapping("/oauth2/authorization/metamask")
  public String authorize() {
    // Logic để chuyển hướng người dùng đến trang đăng nhập MetaMask của bạn
    return "redirect:http://localhost:8080/login/oauth2/code/metamask";
  }
}