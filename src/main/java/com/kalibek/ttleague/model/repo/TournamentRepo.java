package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository<Tournament, Long> {

}
