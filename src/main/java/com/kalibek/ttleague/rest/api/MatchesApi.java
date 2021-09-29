package com.kalibek.ttleague.rest.api;

import com.kalibek.ttleague.rest.model.MatchRequest;
import com.kalibek.ttleague.rest.model.MatchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import org.springframework.web.context.request.NativeWebRequest;

@Validated
@Api(value = "matches", description = "the matches API")
public interface MatchesApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * GET /matches/{matchId}
   * Get single match
   *
   * @param matchId  (required)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "getMatch", notes = "Get single match", response = MatchRequest.class, tags = {
      "matches",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = MatchRequest.class)})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/matches/{matchId}",
      produces = {"application/json"}
  )
  default ResponseEntity<MatchRequest> getMatch(
      @ApiParam(value = "", required = true) @PathVariable("matchId") Long matchId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"groupId\" : 0, \"groupPlayerId2\" : 1, \"playerResult2\" : 5, \"groupPlayerId1\" : 6, \"status\" : \"DRAFT\", \"playerResult1\" : 5 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * PUT /matches/{matchId}
   * Update single match
   *
   * @param matchId  (required)
   * @param matchRequest  (optional)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "updateMatch", notes = "Update single match", response = MatchResponse.class, tags = {
      "matches",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = MatchResponse.class)})
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/matches/{matchId}",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<MatchResponse> updateMatch(
      @ApiParam(value = "", required = true) @PathVariable("matchId") Long matchId,
      @ApiParam(value = "") @Valid @RequestBody(required = false) MatchRequest matchRequest) {
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
