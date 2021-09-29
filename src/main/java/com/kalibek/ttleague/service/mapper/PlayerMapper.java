package com.kalibek.ttleague.service.mapper;

import com.kalibek.ttleague.model.entity.Player;
import com.kalibek.ttleague.rest.model.PlayerRequest;
import com.kalibek.ttleague.rest.model.PlayerResponse;
import java.time.LocalDateTime;

public class PlayerMapper {

  public static PlayerResponse toPlayerResponse(Player player) {
    return new PlayerResponse(
        player.getId(),
        player.getName(),
        player.getRating(),
        player.getCreated(),
        player.getUpdated()
    );
  }

  public static void mergePlayer(Player player, PlayerRequest playerRequest) {
    player.setName(playerRequest.getName());
    player.setRating(playerRequest.getRating());
    player.setUpdated(LocalDateTime.now());
  }

}
