package com.kalibek.ttleague.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SeriesRequest {

  private final String name;
  private final Status status;


}

