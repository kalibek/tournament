package com.kalibek.ttleague.rest.api;

import com.kalibek.ttleague.rest.model.SeriesRequest;
import com.kalibek.ttleague.rest.model.SeriesResponse;
import com.kalibek.ttleague.rest.model.TournamentRequest;
import com.kalibek.ttleague.rest.model.TournamentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

@Validated
@Api(value = "series", description = "the series API")
public interface SeriesApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /series
   * Create new series
   *
   * @param seriesRequest  (optional)
   * @return Created response (status code 201)
   */
  @ApiOperation(value = "", nickname = "createSeries", notes = "Create new series", response = SeriesResponse.class, tags = {
      "series",})
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created response", response = SeriesResponse.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/series",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<SeriesResponse> createSeries(
      @ApiParam(value = "") @Valid @RequestBody(required = false) SeriesRequest seriesRequest) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "null";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * POST /series/{seriesId}/tournaments
   * Create new series
   *
   * @param seriesId  (required)
   * @param tournamentRequest  (optional)
   * @return Created response (status code 201)
   */
  @ApiOperation(value = "", nickname = "createTournament", notes = "Create new series", response = TournamentResponse.class, tags = {
      "series",})
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created response", response = TournamentResponse.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/series/{seriesId}/tournaments",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<TournamentResponse> createTournament(
      @ApiParam(value = "", required = true) @PathVariable("seriesId") Long seriesId,
      @ApiParam(value = "") @Valid @RequestBody(required = false) TournamentRequest tournamentRequest) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "null";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * DELETE /series/{seriesId}
   * Remove series
   *
   * @param seriesId  (required)
   * @return Ok response (status code 200)
   *         or Not Found (status code 404)
   *         or Forbidden (status code 403)
   */
  @ApiOperation(value = "", nickname = "deleteSeries", notes = "Remove series", tags = {"series",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 403, message = "Forbidden")})
  @RequestMapping(
      method = RequestMethod.DELETE,
      value = "/series/{seriesId}"
  )
  default ResponseEntity<Void> deleteSeries(
      @ApiParam(value = "", required = true) @PathVariable("seriesId") Long seriesId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /series/{seriesId}
   * Get single series
   *
   * @param seriesId  (required)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "getSeries", notes = "Get single series", response = SeriesRequest.class, tags = {
      "series",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = SeriesRequest.class)})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/series/{seriesId}",
      produces = {"application/json"}
  )
  default ResponseEntity<SeriesRequest> getSeries(
      @ApiParam(value = "", required = true) @PathVariable("seriesId") Long seriesId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"name\" : \"name\", \"status\" : \"draft\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /series
   * List all series
   *
   * @param offset Pagination parameter for list operations (optional)
   * @param limit Pagination parameter for list operations (optional)
   * @param sortBy Order by field parameter for list operations (optional)
   * @param sortOrder Sort by ASC|DESC parameter for list operations (optional)
   * @return Successful response (status code 200)
   */
  @ApiOperation(value = "", nickname = "listSeries", notes = "List all series", response = SeriesResponse.class, responseContainer = "List", tags = {
      "series",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful response", response = SeriesResponse.class, responseContainer = "List")})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/series",
      produces = {"application/json"}
  )
  default ResponseEntity<List<SeriesResponse>> listSeries(
      @ApiParam(value = "Pagination parameter for list operations") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Pagination parameter for list operations") @Valid @RequestParam(value = "limit", required = false) Integer limit,
      @ApiParam(value = "Order by field parameter for list operations") @Valid @RequestParam(value = "sortBy", required = false) String sortBy,
      @ApiParam(value = "Sort by ASC|DESC parameter for list operations", allowableValues = "ASC, DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "null";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /series/{seriesId}/tournaments
   * List all series
   *
   * @param seriesId  (required)
   * @param offset Pagination parameter for list operations (optional)
   * @param limit Pagination parameter for list operations (optional)
   * @param sortBy Order by field parameter for list operations (optional)
   * @param sortOrder Sort by ASC|DESC parameter for list operations (optional)
   * @return Successful response (status code 200)
   */
  @ApiOperation(value = "", nickname = "listTournaments", notes = "List all series", response = TournamentResponse.class, responseContainer = "List", tags = {
      "series",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful response", response = TournamentResponse.class, responseContainer = "List")})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/series/{seriesId}/tournaments",
      produces = {"application/json"}
  )
  default ResponseEntity<List<TournamentResponse>> listTournaments(
      @ApiParam(value = "", required = true) @PathVariable("seriesId") Long seriesId,
      @ApiParam(value = "Pagination parameter for list operations") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Pagination parameter for list operations") @Valid @RequestParam(value = "limit", required = false) Integer limit,
      @ApiParam(value = "Order by field parameter for list operations") @Valid @RequestParam(value = "sortBy", required = false) String sortBy,
      @ApiParam(value = "Sort by ASC|DESC parameter for list operations", allowableValues = "ASC, DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "null";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * PUT /series/{seriesId}
   * Update single series
   *
   * @param seriesId  (required)
   * @param seriesRequest  (optional)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "updateSeries", notes = "Update single series", response = SeriesResponse.class, tags = {
      "series",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = SeriesResponse.class)})
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/series/{seriesId}",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<SeriesResponse> updateSeries(
      @ApiParam(value = "", required = true) @PathVariable("seriesId") Long seriesId,
      @ApiParam(value = "") @Valid @RequestBody(required = false) SeriesRequest seriesRequest) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "null";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

}
