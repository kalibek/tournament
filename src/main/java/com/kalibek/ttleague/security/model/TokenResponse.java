package com.kalibek.ttleague.security.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TokenResponse {

  private final String accessToken;
  private final String refreshToken;


}

