package com.kalibek.ttleague.service;

import static com.kalibek.ttleague.service.util.PageableUtils.toPageable;

import com.kalibek.ttleague.model.entity.Series;
import com.kalibek.ttleague.model.repo.SeriesRepo;
import com.kalibek.ttleague.rest.model.SeriesRequest;
import com.kalibek.ttleague.rest.model.SeriesResponse;
import com.kalibek.ttleague.security.model.Roles;
import com.kalibek.ttleague.service.exception.SeriesNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesService {

  private final SeriesRepo seriesRepo;

  public List<SeriesResponse> listSeries(Integer offset, Integer limit, String sortBy,
      String sortOrder) {
    return seriesRepo.findAll(
            toPageable(offset, limit, sortBy, sortOrder)).stream()
        .map(this::toSeriesResponse)
        .collect(Collectors.toList());
  }

  public SeriesResponse getSeries(Long seriesId) {
    return seriesRepo.findById(seriesId)
        .map(this::toSeriesResponse)
        .orElseThrow(SeriesNotFoundException::new);
  }

  @RolesAllowed(Roles.ROLE_ADMIN)
  public SeriesResponse createSeries(SeriesRequest seriesRequest) {
    Series series = new Series();
    series.setName(seriesRequest.getName());
    seriesRepo.save(series);
    return toSeriesResponse(series);
  }

  @RolesAllowed(Roles.ROLE_ADMIN)
  public void deleteSeries(Long seriesId) {
    seriesRepo.deleteById(seriesId);
  }


  @RolesAllowed(Roles.ROLE_ADMIN)
  public SeriesResponse updateSeries(Long seriesId, SeriesRequest seriesRequest) {
    Series series = seriesRepo.findById(seriesId).orElseThrow(SeriesNotFoundException::new);
    series.setName(seriesRequest.getName());
    return toSeriesResponse(seriesRepo.save(series));
  }

  private SeriesResponse toSeriesResponse(Series series) {
    return new SeriesResponse(
        series.getId(),
        series.getCreated(),
        series.getUpdated(),
        series.getName()
    );
  }

}
