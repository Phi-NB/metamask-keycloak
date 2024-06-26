package com.example.metamask_idp.dto;

public class MetamaskAuthRequest {

  private String address;
  private String signature;
  private String message;

  // Getters và setters
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
