package com.kalibek.ttleague.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.kalibek.ttleague.model.entity.GroupPlayer;
import com.kalibek.ttleague.model.entity.Match;
import com.kalibek.ttleague.model.repo.GroupPlayerRepo;
import com.kalibek.ttleague.model.repo.GroupRepo;
import com.kalibek.ttleague.model.repo.MatchRepo;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(
    classes = MatchService.class
)
class MatchServiceTest {

  private static final long GROUP_ID = 1;
  @Autowired
  private MatchService matchService;

  @MockBean
  private MatchRepo matchRepo;
  @MockBean
  private GroupRepo groupRepo;
  @MockBean
  private GroupPlayerRepo groupPlayerRepo;

  @Captor
  private ArgumentCaptor<Match> matchArgumentCaptor;


  private final GroupPlayer p1 = new GroupPlayer();
  private final GroupPlayer p2 = new GroupPlayer();
  private final GroupPlayer p3 = new GroupPlayer();

  @Test
  void createMatchesShouldCreateOnlyUniqueMatches() {
    when(groupPlayerRepo.findByGroupOrderByPlayerRating(anyLong()))
        .thenReturn(withPlayers());

    matchService.createMatches(GROUP_ID);

    verify(matchRepo, times(3)).save(matchArgumentCaptor.capture());
  }

  @Test
  void createMatchesShouldNotCreateMatchIfAlreadyPresent() {
    when(groupPlayerRepo.findByGroupOrderByPlayerRating(anyLong()))
        .thenReturn(withPlayers());
    when(matchRepo.findByGroupId(anyLong()))
        .thenReturn(withMatches());

    matchService.createMatches(GROUP_ID);

    verify(matchRepo, times(2)).save(matchArgumentCaptor.capture());
  }

  private List<Match> withMatches() {
    Match match = new Match();
    match.setGroupPlayer1(p1);
    match.setGroupPlayer2(p2);

    return Collections.singletonList(match);
  }

  private List<GroupPlayer> withPlayers() {

    return List.of(p1, p2, p3);
  }


}