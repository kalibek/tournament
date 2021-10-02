package com.kalibek.ttleague.domain.entity;

import com.kalibek.ttleague.rest.model.Status;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "tournaments")
@Entity
@Data
public class Tournament {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne(optional = false)
  @JoinColumn(name = "series_id", nullable = false)
  private Series series;

  @Column(name = "run_date", nullable = false)
  private LocalDateTime runDate;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "created", nullable = false)
  private LocalDateTime created = LocalDateTime.now();

  @Column(name = "updated", nullable = false)
  private LocalDateTime updated = LocalDateTime.now();



}