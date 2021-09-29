package com.kalibek.ttleague.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "rating")
@Entity
@Data
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "player_id")
  private Player player;

  @Column(name = "match_id")
  private Long matchId;

  @Column(name = "tournament_id")
  private Long tournamentId;

  @Column(name = "current_rating", nullable = false)
  private Integer currentRating;

  @Column(name = "delta", nullable = false)
  private Integer delta;

  @Column(name = "created", nullable = false)
  private LocalDateTime created = LocalDateTime.now();

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated = LocalDateTime.now();




}