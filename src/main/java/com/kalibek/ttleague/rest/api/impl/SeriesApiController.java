package com.kalibek.ttleague.rest.api.impl;

import com.kalibek.ttleague.rest.api.SeriesApi;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

@Controller
@RequestMapping("${openapi.tournament.base-path:/api/v1.0.0}")
public class SeriesApiController implements SeriesApi {

  private final NativeWebRequest request;

  @org.springframework.beans.factory.annotation.Autowired
  public SeriesApiController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

}
