package com.kalibek.ttleague.domain.repo;

import com.kalibek.ttleague.domain.entity.Match;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MatchRepo extends JpaRepository<Match, Long> {

  List<Match> findByGroupId(long groupId);

  List<Match> findByGroupId(long groupId, Pageable pageable);

  @Modifying
  @Query(
      value = """
          delete from matches m where m.group_id = :groupId 
          and (m.group_player1_id = :playerId or m.group_player2_id = :playerId)
          """,
      nativeQuery = true
  )
  void deleteAllByGroupIdAndGroupPlayerId(Long groupId, Long playerId);
}
