package com.kalibek.ttleague.service;

import static com.kalibek.ttleague.service.util.PageableUtils.toPageable;

import com.kalibek.ttleague.model.entity.Series;
import com.kalibek.ttleague.model.entity.Tournament;
import com.kalibek.ttleague.model.repo.SeriesRepo;
import com.kalibek.ttleague.model.repo.TournamentRepo;
import com.kalibek.ttleague.rest.model.TournamentRequest;
import com.kalibek.ttleague.rest.model.TournamentResponse;
import com.kalibek.ttleague.security.model.Roles;
import com.kalibek.ttleague.service.exception.SeriesNotFoundException;
import com.kalibek.ttleague.service.exception.TournamentNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TournamentService {

  private final TournamentRepo tournamentRepo;
  private final SeriesRepo seriesRepo;

  public List<TournamentResponse> listTournaments(Long seriesId, Integer offset, Integer limit,
      String sortBy, String sortOrder) {
    return tournamentRepo.findBySeriesId(seriesId,
            toPageable(offset, limit, sortBy, sortOrder)).stream()
        .map(this::toTournamentResponse)
        .collect(Collectors.toList());
  }


  public TournamentResponse getTournament(Long tournamentId) {
    return toTournamentResponse(tournamentRepo.findById(tournamentId).orElseThrow(
        TournamentNotFoundException::new));
  }

  @RolesAllowed(Roles.ROLE_ADMIN)
  public TournamentResponse createTournament(Long seriesId,
      TournamentRequest tournamentRequest) {
    Series series = seriesRepo.findById(seriesId).orElseThrow(SeriesNotFoundException::new);

    Tournament tournament = new Tournament();
    mergeTournament(tournament, tournamentRequest);

    tournament.setSeries(series);
    tournamentRepo.save(tournament);
    return toTournamentResponse(tournament);
  }

  @RolesAllowed(Roles.ROLE_ADMIN)
  public TournamentResponse updateTournament(Long tournamentId,
      TournamentRequest tournamentRequest) {

    Tournament tournament = tournamentRepo.findById(tournamentId)
        .orElseThrow(TournamentNotFoundException::new);
    mergeTournament(tournament, tournamentRequest);
    tournamentRepo.save(tournament);
    return toTournamentResponse(tournament);
  }

  public void deleteTournament(Long tournamentId) {
    tournamentRepo.deleteById(tournamentId);
  }

  private void mergeTournament(Tournament tournament, TournamentRequest tournamentRequest) {
    tournament.setName(tournamentRequest.getName());
    tournament.setRunDate(tournamentRequest.getRunDate());
    tournament.setStatus(tournamentRequest.getStatus());
  }

  private TournamentResponse toTournamentResponse(Tournament tournament) {
    return new TournamentResponse(
        tournament.getId(),
        tournament.getCreated(),
        tournament.getUpdated(),
        tournament.getName(),
        tournament.getStatus(),
        tournament.getRunDate()
    );
  }


}
