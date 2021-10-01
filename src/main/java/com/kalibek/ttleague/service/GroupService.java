package com.kalibek.ttleague.service;

import static com.kalibek.ttleague.service.util.PageableUtils.toPageable;

import com.kalibek.ttleague.model.entity.Group;
import com.kalibek.ttleague.model.entity.Tournament;
import com.kalibek.ttleague.model.repo.GroupRepo;
import com.kalibek.ttleague.model.repo.TournamentRepo;
import com.kalibek.ttleague.rest.model.GroupRequest;
import com.kalibek.ttleague.rest.model.GroupResponse;
import com.kalibek.ttleague.security.model.Roles;
import com.kalibek.ttleague.service.exception.GroupNotFoundException;
import com.kalibek.ttleague.service.exception.TournamentNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

  private final GroupRepo groupRepo;
  private final TournamentRepo tournamentRepo;

  public List<GroupResponse> listGroups(Long tournamentId, Integer offset, Integer limit,
      String sortBy, String sortOrder) {
    return groupRepo.findByTournamentId(tournamentId,
            toPageable(offset, limit, sortBy, sortOrder)).stream()
        .map(this::toGroupResponse)
        .collect(Collectors.toList());
  }

  @RolesAllowed(Roles.ADMIN)
  public GroupResponse createGroup(Long tournamentId,
      GroupRequest groupRequest) {
    Tournament tournament = tournamentRepo.findById(tournamentId).orElseThrow(
        TournamentNotFoundException::new);
    Group group = new Group();
    mergeGroup(group, groupRequest);
    group.setTournament(tournament);
    groupRepo.save(group);
    return toGroupResponse(group);
  }

  public GroupResponse getGroup(Long groupId) {
    return toGroupResponse(groupRepo.findById(groupId).orElseThrow(GroupNotFoundException::new));
  }

  @RolesAllowed(Roles.ADMIN)
  public void deleteGroup(Long groupId) {
    groupRepo.deleteById(groupId);
  }

  @RolesAllowed(Roles.ADMIN)
  public GroupResponse updateGroup(Long groupId, GroupRequest groupRequest) {
    Group group = groupRepo.findById(groupId).orElseThrow(GroupNotFoundException::new);
    mergeGroup(group, groupRequest);
    groupRepo.save(group);
    return toGroupResponse(group);
  }

  private void mergeGroup(Group group, GroupRequest groupRequest) {
    group.setName(groupRequest.getName());
    group.setRunDate(groupRequest.getRunDate());
    group.setPosition(groupRequest.getPosition());
    group.setStatus(groupRequest.getStatus());
  }

  private GroupResponse toGroupResponse(Group group) {
    return new GroupResponse(
        group.getId(),
        group.getCreated(),
        group.getUpdated(),
        group.getName(),
        group.getStatus(),
        group.getTournament().getId(),
        group.getRunDate(),
        group.getPosition()
    );
  }

}
