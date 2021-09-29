package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupRequest {

  private final Long tournamentId;
  private final LocalDateTime runDate;
  private final Integer position;
  private final String name;
}