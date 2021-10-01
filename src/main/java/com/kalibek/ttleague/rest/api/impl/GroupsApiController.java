package com.kalibek.ttleague.rest.api.impl;

import com.kalibek.ttleague.rest.api.GroupsApi;
import com.kalibek.ttleague.rest.model.GroupPlayerResponse;
import com.kalibek.ttleague.rest.model.GroupRequest;
import com.kalibek.ttleague.rest.model.GroupResponse;
import com.kalibek.ttleague.rest.model.MatchResponse;
import com.kalibek.ttleague.service.GroupPlayerService;
import com.kalibek.ttleague.service.GroupService;
import com.kalibek.ttleague.service.MatchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.tournament.base-path:/api/v1.0.0}")
@RequiredArgsConstructor
public class GroupsApiController implements GroupsApi {

  private final GroupService groupService;
  private final GroupPlayerService groupPlayerService;
  private final MatchService matchService;

  @Override
  public ResponseEntity<GroupPlayerResponse> addPlayerToGroup(Long groupId, Long playerId) {
    return ResponseEntity.ok(groupPlayerService.addPlayerToGroup(groupId, playerId));
  }

  @Override
  public ResponseEntity<Void> deleteGroup(Long groupId) {
    groupService.deleteGroup(groupId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<Void> deletePlayerFromGroup(Long groupId, Long playerId) {
    groupPlayerService.deletePlayerFromGroup(groupId, playerId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<GroupResponse> getGroup(Long groupId) {
    return ResponseEntity.ok(groupService.getGroup(groupId));
  }

  @Override
  public ResponseEntity<GroupPlayerResponse> getGroupPlayer(Long groupId, Long playerId) {
    return ResponseEntity.ok(groupPlayerService.getGroupPlayer(groupId, playerId));
  }

  @Override
  public ResponseEntity<List<GroupPlayerResponse>> listGroupPlayers(Long groupId, Integer offset,
      Integer limit, String sortBy, String sortOrder) {
    return ResponseEntity.ok(
        groupPlayerService.listGroupPlayers(groupId));
  }

  @Override
  public ResponseEntity<List<MatchResponse>> listMatches(Long groupId, Integer offset,
      Integer limit, String sortBy, String sortOrder) {
    return ResponseEntity.ok(matchService.listMatches(groupId, offset, limit, sortBy, sortOrder));
  }

  @Override
  public ResponseEntity<GroupResponse> updateGroup(Long groupId, GroupRequest groupRequest) {
    return ResponseEntity.ok(groupService.updateGroup(groupId, groupRequest));
  }
}
