package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match, Long> {

}
