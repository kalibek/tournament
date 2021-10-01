package com.kalibek.ttleague.rest.api;

import com.kalibek.ttleague.rest.model.GroupRequest;
import com.kalibek.ttleague.rest.model.GroupResponse;
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
@Api(value = "tournaments", description = "the tournaments API")
public interface TournamentsApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /tournaments/{tournamentId}/groups Create new series
   *
   * @param tournamentId (required)
   * @param groupRequest (optional)
   * @return Created response (status code 201)
   */
  @ApiOperation(value = "", nickname = "createGroup", notes = "Create new series", response = GroupResponse.class, tags = {
      "tournaments",})
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created response", response = GroupResponse.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/tournaments/{tournamentId}/groups",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<GroupResponse> createGroup(
      @ApiParam(value = "", required = true) @PathVariable("tournamentId") Long tournamentId,
      @ApiParam(value = "") @Valid @RequestBody(required = false) GroupRequest groupRequest) {
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
   * DELETE /tournaments/{tournamentId} Remove series
   *
   * @param tournamentId (required)
   * @return Ok response (status code 200) or Not Found (status code 404) or Forbidden (status code
   * 403)
   */
  @ApiOperation(value = "", nickname = "deleteTournament", notes = "Remove series", tags = {
      "tournaments",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 403, message = "Forbidden")})
  @RequestMapping(
      method = RequestMethod.DELETE,
      value = "/tournaments/{tournamentId}"
  )
  default ResponseEntity<Void> deleteTournament(
      @ApiParam(value = "", required = true) @PathVariable("tournamentId") Long tournamentId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /tournaments/{tournamentId} Get single series
   *
   * @param tournamentId (required)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "getTournament", notes = "Get single series", response = TournamentResponse.class, tags = {
      "tournaments",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = TournamentResponse.class)})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/tournaments/{tournamentId}",
      produces = {"application/json"}
  )
  default ResponseEntity<TournamentResponse> getTournament(
      @ApiParam(value = "", required = true) @PathVariable("tournamentId") Long tournamentId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"runDate\" : \"2000-01-23T04:56:07.000+00:00\", \"seriesId\" : 0 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /tournaments/{tournamentId}/groups List all series
   *
   * @param tournamentId (required)
   * @param offset Pagination parameter for list operations (optional)
   * @param limit Pagination parameter for list operations (optional)
   * @param sortBy Order by field parameter for list operations (optional)
   * @param sortOrder Sort by ASC|DESC parameter for list operations (optional)
   * @return Successful response (status code 200)
   */
  @ApiOperation(value = "", nickname = "listGroups", notes = "List all series", response = GroupResponse.class, responseContainer = "List", tags = {
      "tournaments",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful response", response = GroupResponse.class, responseContainer = "List")})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/tournaments/{tournamentId}/groups",
      produces = {"application/json"}
  )
  default ResponseEntity<List<GroupResponse>> listGroups(
      @ApiParam(value = "", required = true) @PathVariable("tournamentId") Long tournamentId,
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
   * PUT /tournaments/{tournamentId} Update single series
   *
   * @param tournamentId (required)
   * @param tournamentRequest (optional)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "updateTournament", notes = "Update single series", response = TournamentResponse.class, tags = {
      "tournaments",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = TournamentResponse.class)})
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/tournaments/{tournamentId}",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<TournamentResponse> updateTournament(
      @ApiParam(value = "", required = true) @PathVariable("tournamentId") Long tournamentId,
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

}
