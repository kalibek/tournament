package com.kalibek.ttleague.rest.api.impl;

import com.kalibek.ttleague.rest.api.SeriesApi;
import com.kalibek.ttleague.rest.model.SeriesRequest;
import com.kalibek.ttleague.rest.model.SeriesResponse;
import com.kalibek.ttleague.rest.model.TournamentRequest;
import com.kalibek.ttleague.rest.model.TournamentResponse;
import com.kalibek.ttleague.service.SeriesService;
import com.kalibek.ttleague.service.TournamentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.tournament.base-path:/api/v1.0.0}")
@RequiredArgsConstructor
public class SeriesApiController implements SeriesApi {

  private final SeriesService seriesService;
  private final TournamentService tournamentService;

  @Override
  public ResponseEntity<SeriesResponse> createSeries(SeriesRequest seriesRequest) {
    return ResponseEntity.ok(seriesService.createSeries(seriesRequest));
  }

  @Override
  public ResponseEntity<TournamentResponse> createTournament(Long seriesId,
      TournamentRequest tournamentRequest) {
    return ResponseEntity.ok(tournamentService.createTournament(seriesId, tournamentRequest));
  }

  @Override
  public ResponseEntity<Void> deleteSeries(Long seriesId) {
    seriesService.deleteSeries(seriesId);
    return ResponseEntity.ok(null);
  }

  @Override
  public ResponseEntity<SeriesResponse> getSeries(Long seriesId) {
    return ResponseEntity.ok(seriesService.getSeries(seriesId));
  }

  @Override
  public ResponseEntity<List<SeriesResponse>> listSeries(Integer offset, Integer limit,
      String sortBy, String sortOrder) {
    return ResponseEntity.ok(seriesService.listSeries(offset, limit, sortBy, sortOrder));
  }

  @Override
  public ResponseEntity<List<TournamentResponse>> listTournaments(Long seriesId, Integer offset,
      Integer limit, String sortBy, String sortOrder) {
    return ResponseEntity.ok(tournamentService.listTournaments(seriesId, offset, limit, sortBy, sortOrder));
  }

  @Override
  public ResponseEntity<SeriesResponse> updateSeries(Long seriesId, SeriesRequest seriesRequest) {
    return ResponseEntity.ok(seriesService.updateSeries(seriesId, seriesRequest));
  }
}
