package com.kalibek.ttleague.domain.repo;

import com.kalibek.ttleague.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {

}
