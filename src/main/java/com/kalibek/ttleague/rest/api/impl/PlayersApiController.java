package com.kalibek.ttleague.rest.api.impl;

import com.kalibek.ttleague.rest.api.PlayersApi;
import com.kalibek.ttleague.rest.model.PlayerRequest;
import com.kalibek.ttleague.service.PlayerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import com.kalibek.ttleague.rest.model.PlayerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.tournament.base-path:/api/v1.0.0}")
@RequiredArgsConstructor
public class PlayersApiController implements PlayersApi {

  private final PlayerService playerService;

  @Override
  public ResponseEntity<List<PlayerResponse>> listPlayers(Integer offset, Integer limit,
      String sortBy, String sortOrder) {
    return ResponseEntity.ok(playerService.listPlayers(offset, limit, sortBy, sortOrder));
  }

  @Override
  public ResponseEntity<PlayerResponse> createPlayer(PlayerRequest playerRequest) {
    return ResponseEntity.ok(playerService.createPlayer(playerRequest));
  }

  @Override
  public ResponseEntity<PlayerResponse> updatePlayer(Long playerId, PlayerRequest playerRequest) {
    return ResponseEntity.ok(playerService.updatePlayer(playerId, playerRequest));
  }

  @Override
  public ResponseEntity<Void> deletePlayer(Long playerId) {
    playerService.deletePlayer(playerId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<PlayerResponse> getPlayer(Long playerId) {
    return ResponseEntity.ok(playerService.getPlayer(playerId));
  }
}
