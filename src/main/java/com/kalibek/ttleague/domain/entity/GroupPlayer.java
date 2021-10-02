package com.kalibek.ttleague.domain.entity;

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

@Table(name = "group_players")
@Entity
@Data
public class GroupPlayer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "group_id", nullable = false)
  private Group group;

  @ManyToOne(optional = false)
  @JoinColumn(name = "player_id", nullable = false)
  private Player player;

  @Column(name = "starting_position", nullable = false)
  private Integer startingPosition;

  @Column(name = "score")
  private Integer score;

  @Column(name = "place")
  private Integer place;

  @Column(name = "created", nullable = false)
  private LocalDateTime created = LocalDateTime.now();

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated = LocalDateTime.now();

}