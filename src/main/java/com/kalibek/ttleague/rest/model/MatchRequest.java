package com.kalibek.ttleague.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MatchRequest {

  private final Status status;
  private final Long groupId;
  private final Long groupPlayerId1;
  private final Long groupPlayerId2;
  private final Integer playerResult1;
  private final Integer playerResult2;


}

