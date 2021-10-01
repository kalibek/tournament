package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TournamentRequest {

  private final Long seriesId;
  private final LocalDateTime runDate;
  private final String name;
  private final Status status;


}

