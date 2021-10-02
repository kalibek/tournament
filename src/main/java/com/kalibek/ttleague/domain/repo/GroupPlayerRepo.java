package com.kalibek.ttleague.domain.repo;

import com.kalibek.ttleague.domain.entity.GroupPlayer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupPlayerRepo extends JpaRepository<GroupPlayer, Long> {

  @Query(
      value = """
          select gp.*
          from group_players gp
          inner join players p on p.id = gp.player_id
          where gp.group_id = :groupId
          order by p.rating desc
          """,
      nativeQuery = true
  )
  List<GroupPlayer> findByGroupOrderByPlayerRating(long groupId);

  void deleteAllByGroupIdAndPlayerId(long groupId, long playerId);

  Optional<GroupPlayer> findByGroupIdAndPlayerId(long groupId, long playerId);
}
