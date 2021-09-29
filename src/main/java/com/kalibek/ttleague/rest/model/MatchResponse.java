package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MatchResponse {

  private final Long id;
  private final LocalDateTime created;
  private final LocalDateTime updated;
  private final Status status;
  private final Long groupId;
  private final Long groupPlayerId1;
  private final Long groupPlayerId2;
  private final Integer playerResult1;
  private final Integer playerResult2;


}
