package com.kalibek.ttleague.service;

import com.kalibek.ttleague.domain.entity.Group;
import com.kalibek.ttleague.domain.entity.GroupPlayer;
import com.kalibek.ttleague.domain.entity.Player;
import com.kalibek.ttleague.domain.repo.GroupPlayerRepo;
import com.kalibek.ttleague.domain.repo.GroupRepo;
import com.kalibek.ttleague.domain.repo.PlayerRepo;
import com.kalibek.ttleague.rest.model.GroupPlayerResponse;
import com.kalibek.ttleague.rest.model.Status;
import com.kalibek.ttleague.security.model.Roles;
import com.kalibek.ttleague.service.exception.GroupIsClosedException;
import com.kalibek.ttleague.service.exception.GroupNotFoundException;
import com.kalibek.ttleague.service.exception.PlayerNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupPlayerService {

  private final GroupRepo groupRepo;
  private final GroupPlayerRepo groupPlayerRepo;
  private final PlayerRepo playerRepo;
  private final MatchService matchService;

  @RolesAllowed(Roles.ADMIN)
  @Transactional
  public GroupPlayerResponse addPlayerToGroup(Long groupId, Long playerId) {
    Group group = groupRepo.findById(groupId)
        .orElseThrow(GroupNotFoundException::new);
    if (group.getStatus() != Status.DRAFT) {
      throw new GroupIsClosedException();
    }

    Player player = playerRepo.findById(playerId)
        .orElseThrow(PlayerNotFoundException::new);
    GroupPlayer groupPlayer = new GroupPlayer();
    groupPlayer.setGroup(group);
    groupPlayer.setPlayer(player);
    groupPlayer.setStartingPosition(0);
    groupPlayerRepo.save(groupPlayer);
    seedGroup(group.getId());
    return toGroupPlayerResponse(groupPlayerRepo.getById(groupPlayer.getId()));
  }

  @RolesAllowed(Roles.ADMIN)
  @Transactional
  public void deletePlayerFromGroup(Long groupId, Long playerId) {
    Group group = groupRepo.findById(groupId)
        .orElseThrow(GroupNotFoundException::new);
    if (group.getStatus() != Status.DRAFT) {
      throw new GroupIsClosedException();
    }
    matchService.deleteAllByGroupIdAndPlayerId(groupId, playerId);
    groupPlayerRepo.deleteAllByGroupIdAndPlayerId(groupId, playerId);
    seedGroup(groupId);
  }

  private void seedGroup(long groupId) {
    sortGroup(groupId);
    matchService.createMatches(groupId);
  }

  private void sortGroup(long groupId) {
    List<GroupPlayer> groupPlayers = groupPlayerRepo.findByGroupOrderByPlayerRating(groupId);
    IntStream.range(0, groupPlayers.size()).forEach(position -> {
      GroupPlayer groupPlayer = groupPlayers.get(position);
      groupPlayer.setStartingPosition(position + 1);
      groupPlayerRepo.save(groupPlayer);
    });
  }

  public GroupPlayerResponse getGroupPlayer(Long groupId, Long playerId) {
    return toGroupPlayerResponse(groupPlayerRepo.findByGroupIdAndPlayerId(groupId, playerId)
        .orElseThrow(PlayerNotFoundException::new));
  }

  public List<GroupPlayerResponse> listGroupPlayers(Long groupId) {
    return groupPlayerRepo.findByGroupOrderByPlayerRating(groupId)
        .stream().map(this::toGroupPlayerResponse)
        .collect(Collectors.toList());
  }

  private GroupPlayerResponse toGroupPlayerResponse(GroupPlayer groupPlayer) {
    return new GroupPlayerResponse(
        groupPlayer.getGroup().getId(),
        groupPlayer.getPlayer().getId(),
        groupPlayer.getPlayer().getName(),
        groupPlayer.getPlayer().getRating(),
        groupPlayer.getStartingPosition(),
        groupPlayer.getId(),
        groupPlayer.getCreated(),
        groupPlayer.getUpdated(),
        groupPlayer.getScore(),
        groupPlayer.getPlace()
    );
  }

}
