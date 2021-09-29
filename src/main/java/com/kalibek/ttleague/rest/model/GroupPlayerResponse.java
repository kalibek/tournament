package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupPlayerResponse {

  private final Long groupId;
  private final Long playerId;
  private final Integer startingPosition;
  private final Long id;
  private final LocalDateTime created;
  private final LocalDateTime updated;

}