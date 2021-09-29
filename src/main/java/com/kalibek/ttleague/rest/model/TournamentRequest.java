package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TournamentRequest {

  private Long seriesId;
  private LocalDateTime runDate;
  private String name;
  private Status status;


}

