package com.kalibek.ttleague.service;

import static com.kalibek.ttleague.service.mapper.PlayerMapper.mergePlayer;
import static com.kalibek.ttleague.service.mapper.PlayerMapper.toPlayerResponse;
import static com.kalibek.ttleague.service.util.PageableUtils.toPagebale;

import com.kalibek.ttleague.model.entity.Player;
import com.kalibek.ttleague.model.repo.PlayerRepo;
import com.kalibek.ttleague.rest.model.PlayerRequest;
import com.kalibek.ttleague.rest.model.PlayerResponse;
import com.kalibek.ttleague.service.exception.PlayerNotFoundException;
import com.kalibek.ttleague.service.mapper.PlayerMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepo playerRepo;

  public List<PlayerResponse> listPlayers(Integer offset, Integer limit, String sortBy,
      String sortOrder) {
    return playerRepo.findAll(
            toPagebale(offset, limit, sortBy, sortOrder)).stream()
        .map(PlayerMapper::toPlayerResponse)
        .collect(Collectors.toList());
  }

  public PlayerResponse createPlayer(PlayerRequest playerRequest) {
    Player player = new Player();
    mergePlayer(player, playerRequest);
    return toPlayerResponse(playerRepo.save(player));
  }

  public PlayerResponse updatePlayer(Long playerId, PlayerRequest playerRequest) {
    Player player = playerRepo.findById(playerId).orElseThrow(PlayerNotFoundException::new);
    mergePlayer(player, playerRequest);
    return toPlayerResponse(playerRepo.save(player));
  }

  public void deletePlayer(Long playerId) {
    playerRepo.deleteById(playerId);
  }
}
