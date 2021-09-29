package com.kalibek.ttleague.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "matches")
@Entity
@Data
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "group_id", nullable = false)
  private Group group;

  @ManyToOne(optional = false)
  @JoinColumn(name = "group_player1_id", nullable = false)
  private GroupPlayer groupPlayer1;

  @ManyToOne(optional = false)
  @JoinColumn(name = "group_player2_id", nullable = false)
  private GroupPlayer groupPlayer2;

  @Column(name = "player1_result")
  private Integer player1Result;

  @Column(name = "player2_result")
  private Integer player2Result;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "created", nullable = false)
  private LocalDateTime created = LocalDateTime.now();

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated = LocalDateTime.now();




}