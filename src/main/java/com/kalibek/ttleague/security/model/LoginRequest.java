package com.kalibek.ttleague.security.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequest {

  private final String login;
  private final String password;

}

