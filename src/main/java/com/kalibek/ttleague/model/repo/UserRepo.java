package com.kalibek.ttleague.model.repo;

import com.kalibek.ttleague.model.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByLogin(String login);
}
