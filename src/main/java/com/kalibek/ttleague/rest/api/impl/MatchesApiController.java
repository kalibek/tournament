package com.kalibek.ttleague.rest.api.impl;

import com.kalibek.ttleague.rest.api.MatchesApi;
import com.kalibek.ttleague.rest.model.MatchRequest;
import com.kalibek.ttleague.rest.model.MatchResponse;
import com.kalibek.ttleague.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.tournament.base-path:/api/v1.0.0}")
@RequiredArgsConstructor
public class MatchesApiController implements MatchesApi {

  private final MatchService matchService;

  @Override
  public ResponseEntity<MatchResponse> getMatch(Long matchId) {
    return ResponseEntity.ok(matchService.getMatch(matchId));
  }

  @Override
  public ResponseEntity<MatchResponse> updateMatch(Long matchId, MatchRequest matchRequest) {
    return ResponseEntity.ok(matchService.updateMatch(matchId, matchRequest));
  }
}
