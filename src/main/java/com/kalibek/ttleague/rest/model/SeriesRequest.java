package com.kalibek.ttleague.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SeriesRequest {

  private String name;
  private Status status;


}

