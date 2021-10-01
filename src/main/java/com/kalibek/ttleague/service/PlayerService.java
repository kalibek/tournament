package com.kalibek.ttleague.service;

import static com.kalibek.ttleague.service.mapper.PlayerMapper.mergePlayer;
import static com.kalibek.ttleague.service.mapper.PlayerMapper.toPlayerResponse;
import static com.kalibek.ttleague.service.util.PageableUtils.toPageable;

import com.kalibek.ttleague.model.entity.Player;
import com.kalibek.ttleague.model.repo.PlayerRepo;
import com.kalibek.ttleague.rest.model.PlayerRequest;
import com.kalibek.ttleague.rest.model.PlayerResponse;
import com.kalibek.ttleague.security.model.Roles;
import com.kalibek.ttleague.service.exception.PlayerNotFoundException;
import com.kalibek.ttleague.service.mapper.PlayerMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepo playerRepo;

  public List<PlayerResponse> listPlayers(Integer offset, Integer limit, String sortBy,
      String sortOrder) {
    return playerRepo.findAll(
            toPageable(offset, limit, sortBy, sortOrder)).stream()
        .map(PlayerMapper::toPlayerResponse)
        .collect(Collectors.toList());
  }


  public PlayerResponse getPlayer(Long playerId) {
    return playerRepo.findById(playerId)
        .map(PlayerMapper::toPlayerResponse)
        .orElseThrow(PlayerNotFoundException::new);
  }

  @RolesAllowed(Roles.ROLE_ADMIN)
  public PlayerResponse createPlayer(PlayerRequest playerRequest) {
    Player player = new Player();
    mergePlayer(player, playerRequest);
    return toPlayerResponse(playerRepo.save(player));
  }

  @RolesAllowed({Roles.ROLE_ADMIN, Roles.ROLE_JUDGE})
  public PlayerResponse updatePlayer(Long playerId, PlayerRequest playerRequest) {
    Player player = playerRepo.findById(playerId).orElseThrow(PlayerNotFoundException::new);
    mergePlayer(player, playerRequest);
    return toPlayerResponse(playerRepo.save(player));
  }

  @RolesAllowed(Roles.ROLE_ADMIN)
  public void deletePlayer(Long playerId) {
    playerRepo.deleteById(playerId);
  }

}
