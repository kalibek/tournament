package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {

}
