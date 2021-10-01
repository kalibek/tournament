package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.Tournament;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository<Tournament, Long> {

  List<Tournament> findBySeriesId(long seriesId, Pageable pageable);

}
