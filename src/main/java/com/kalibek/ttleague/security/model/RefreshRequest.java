package com.kalibek.ttleague.security.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RefreshRequest {

  private final String refreshToken;

}

