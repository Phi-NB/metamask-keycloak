package com.example.metamask_idp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OAuth2TokenController {

  @PostMapping("/oauth2/token")
  public Map<String, Object> token(@RequestParam Map<String, String> parameters) {
    String code = parameters.get("code");
    // Logic xử lý mã xác thực và trả về token
    return Map.of(
        "access_token", "fake-access-token",
        "token_type", "Bearer",
        "expires_in", 3600,
        "refresh_token", "fake-refresh-token",
        "scope", "openid profile email");
  }
}
