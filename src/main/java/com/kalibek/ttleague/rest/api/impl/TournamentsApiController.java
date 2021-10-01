package com.kalibek.ttleague.rest.api.impl;

import com.kalibek.ttleague.rest.api.TournamentsApi;
import com.kalibek.ttleague.rest.model.GroupRequest;
import com.kalibek.ttleague.rest.model.GroupResponse;
import com.kalibek.ttleague.rest.model.TournamentRequest;
import com.kalibek.ttleague.rest.model.TournamentResponse;
import com.kalibek.ttleague.service.GroupService;
import com.kalibek.ttleague.service.TournamentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.tournament.base-path:/api/v1.0.0}")
@RequiredArgsConstructor
public class TournamentsApiController implements TournamentsApi {

  private final TournamentService tournamentService;
  private final GroupService groupService;

  @Override
  public ResponseEntity<GroupResponse> createGroup(Long tournamentId, GroupRequest groupRequest) {
    return ResponseEntity.ok(groupService.createGroup(tournamentId, groupRequest));
  }

  @Override
  public ResponseEntity<Void> deleteTournament(Long tournamentId) {
    tournamentService.deleteTournament(tournamentId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<TournamentResponse> getTournament(Long tournamentId) {
    return ResponseEntity.ok(tournamentService.getTournament(tournamentId));
  }

  @Override
  public ResponseEntity<List<GroupResponse>> listGroups(Long tournamentId, Integer offset,
      Integer limit, String sortBy, String sortOrder) {
    return ResponseEntity.ok(
        groupService.listGroups(tournamentId, offset, limit, sortBy, sortOrder));
  }

  @Override
  public ResponseEntity<TournamentResponse> updateTournament(Long tournamentId,
      TournamentRequest tournamentRequest) {
    return ResponseEntity.ok(tournamentService.updateTournament(tournamentId, tournamentRequest));
  }
}
