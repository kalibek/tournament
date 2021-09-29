package com.kalibek.ttleague.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlayerRequest {

  private final String name;
  private final Integer rating;

}

