package com.kalibek.ttleague.service;

import static com.kalibek.ttleague.service.util.PageableUtils.toPageable;

import com.kalibek.ttleague.model.entity.Group;
import com.kalibek.ttleague.model.entity.GroupPlayer;
import com.kalibek.ttleague.model.entity.Match;
import com.kalibek.ttleague.model.repo.GroupPlayerRepo;
import com.kalibek.ttleague.model.repo.GroupRepo;
import com.kalibek.ttleague.model.repo.MatchRepo;
import com.kalibek.ttleague.rest.model.MatchRequest;
import com.kalibek.ttleague.rest.model.MatchResponse;
import com.kalibek.ttleague.rest.model.Status;
import com.kalibek.ttleague.security.model.Roles;
import com.kalibek.ttleague.service.exception.MatchNotFoundException;
import com.kalibek.ttleague.service.exception.PlayerNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {

  private final MatchRepo matchRepo;
  private final GroupRepo groupRepo;
  private final GroupPlayerRepo groupPlayerRepo;

  public List<MatchResponse> listMatches(Long groupId, Integer offset, Integer limit, String sortBy,
      String sortOrder) {
    return matchRepo.findByGroupId(groupId, toPageable(offset, limit, sortBy, sortOrder))
        .stream().map(this::toMatchResponse)
        .collect(Collectors.toList());
  }

  public MatchResponse getMatch(Long matchId) {
    return matchRepo.findById(matchId)
        .map(this::toMatchResponse)
        .orElseThrow(MatchNotFoundException::new);
  }

  public void createMatches(long groupId) {
    List<GroupPlayer> groupPlayers = groupPlayerRepo.findByGroupOrderByPlayerRating(groupId);
    List<Match> matches = matchRepo.findByGroupId(groupId);
    for (int i = 0; i < groupPlayers.size() - 1; i++) {
      for (int j = i + 1; j < groupPlayers.size(); j++) {
        var p1 = groupPlayers.get(i);
        var p2 = groupPlayers.get(j);
        if (!isPresent(p1, p2, matches)) {
          createMatch(groupId, p1, p2);
        }
      }
    }
  }

  public void createMatch(long groupId, GroupPlayer p1, GroupPlayer p2) {
    Group group = groupRepo.getById(groupId);
    Match match = new Match();
    match.setGroup(group);
    match.setGroupPlayer1(p1);
    match.setGroupPlayer2(p2);
    match.setStatus(Status.DRAFT);
    matchRepo.save(match);
  }

  @RolesAllowed({Roles.ADMIN, Roles.JUDGE})
  public MatchResponse updateMatch(Long matchId, MatchRequest matchRequest) {
    Match match = matchRepo.findById(matchId).orElseThrow(MatchNotFoundException::new);
    mergeMatch(match, matchRequest);
    matchRepo.save(match);
    return toMatchResponse(match);
  }

  private boolean isPresent(GroupPlayer p1, GroupPlayer p2, List<Match> matches) {
    return matches.stream()
        .anyMatch(m ->
            (m.getGroupPlayer1().equals(p1) && m.getGroupPlayer2().equals(p2))
                || (m.getGroupPlayer1().equals(p2) && m.getGroupPlayer2().equals(p1))
        );
  }


  private MatchResponse toMatchResponse(Match match) {
    return new MatchResponse(
        match.getId(),
        match.getCreated(),
        match.getUpdated(),
        match.getStatus(),
        match.getGroup().getId(),
        match.getGroupPlayer1().getId(),
        match.getGroupPlayer2().getId(),
        match.getPlayer1Result(),
        match.getPlayer2Result()
    );
  }

  private void mergeMatch(Match match, MatchRequest matchRequest) {
    match.setStatus(matchRequest.getStatus());
    match.setPlayer1Result(matchRequest.getPlayerResult1());
    match.setPlayer2Result(matchRequest.getPlayerResult1());
  }

  public void deleteAllByGroupIdAndPlayerId(Long groupId, Long playerId) {
    groupPlayerRepo.findByGroupIdAndPlayerId(groupId, playerId)
        .orElseThrow(PlayerNotFoundException::new);
    matchRepo.deleteAllByGroupIdAndGroupPlayerId(groupId, playerId);
  }
}
