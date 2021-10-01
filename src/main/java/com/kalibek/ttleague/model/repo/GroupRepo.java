package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.Group;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group, Long> {

  List<Group> findByTournamentId(Long tournamentId, Pageable pageable);
}
