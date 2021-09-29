package com.kalibek.ttleague.security.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TokenResponse {

  private String accessToken;
  private String refreshToken;


}

