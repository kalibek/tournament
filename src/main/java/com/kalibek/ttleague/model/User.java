package com.kalibek.ttleague.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "users")
@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "login", nullable = false)
  private String login;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(name = "player_id")
  private Long playerId;

  @Column(name = "created", nullable = false)
  private LocalDateTime created = LocalDateTime.now();

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated = LocalDateTime.now();


}