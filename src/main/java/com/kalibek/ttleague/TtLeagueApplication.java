package com.kalibek.ttleague;

import com.kalibek.ttleague.domain.entity.UserEntity;
import com.kalibek.ttleague.domain.repo.UserRepo;
import com.kalibek.ttleague.security.model.Roles;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@RequiredArgsConstructor
@Slf4j
public class TtLeagueApplication implements ApplicationRunner {

  private final UserRepo repo;
  private final BCryptPasswordEncoder encoder;

  public static void main(String[] args) {
    SpringApplication.run(TtLeagueApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    repo.findByLogin("admin").ifPresentOrElse(
        u -> log.info("admin account is present"),
        () -> {
          UserEntity admin = new UserEntity();
          admin.setLogin("admin");
          admin.setRole(Roles.ADMIN);
          admin.setPasswordHash(encoder.encode("test"));
          repo.save(admin);

          log.info("created default account");

          UserEntity judge = new UserEntity();
          judge.setLogin("judge");
          judge.setRole(Roles.JUDGE);
          judge.setPasswordHash(encoder.encode("test"));
          repo.save(judge);

          UserEntity player = new UserEntity();
          player.setLogin("player");
          player.setRole(Roles.PLAYER);
          player.setPasswordHash(encoder.encode("test"));
          repo.save(player);
        }
    );
  }
}
