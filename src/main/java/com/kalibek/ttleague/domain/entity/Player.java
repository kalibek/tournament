package com.kalibek.ttleague.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "players")
@Entity
@Data
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "rating", nullable = false)
  private Integer rating;

  @Column(name = "created", nullable = false)
  private LocalDateTime created = LocalDateTime.now();

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated = LocalDateTime.now();




}