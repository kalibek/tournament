package com.kalibek.ttleague.rest.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SeriesResponse {

  private final Long id;
  private final LocalDateTime created;
  private final LocalDateTime updated;
  private final String name;

}

