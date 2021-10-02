package com.kalibek.ttleague.domain.repo;

import com.kalibek.ttleague.domain.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByLogin(String login);
}
