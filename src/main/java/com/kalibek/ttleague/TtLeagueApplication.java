package com.kalibek.ttleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TtLeagueApplication {

  public static void main(String[] args) {
    SpringApplication.run(TtLeagueApplication.class, args);
  }

}
