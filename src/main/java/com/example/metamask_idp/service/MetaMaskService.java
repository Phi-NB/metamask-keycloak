package com.example.metamask_idp.service;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class MetaMaskService {
  public void processOAuth2User(OAuth2AuthenticationToken authentication) {
    // Logic xử lý người dùng xác thực từ MetaMask
    System.out.println("User Info: " + authentication.getPrincipal().getAttributes());
  }

  public boolean verifySignature(String address, String signature, String message) {
    // Logic để xác minh chữ ký từ Metamask
    return true; // Thay bằng logic thực tế
  }
}
