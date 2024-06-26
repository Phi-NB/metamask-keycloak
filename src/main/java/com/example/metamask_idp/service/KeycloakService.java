package com.example.metamask_idp.service;

import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

  public String authenticateWithKeycloak(String username) {
    // Logic để gửi yêu cầu xác thực tới Keycloak và nhận lại token
    return "fake-token"; // Thay bằng logic thực tế
  }
}