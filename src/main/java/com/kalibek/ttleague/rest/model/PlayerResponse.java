package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlayerResponse {

  private final Long id;
  private final String name;
  private final Integer rating;
  private final LocalDateTime created;
  private final LocalDateTime updated;

}

