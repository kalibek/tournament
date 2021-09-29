package com.kalibek.ttleague.rest.api;

import com.kalibek.ttleague.rest.model.PlayerRequest;
import com.kalibek.ttleague.rest.model.PlayerResponse;
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
@Api(value = "players", description = "the players API")
public interface PlayersApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /players
   * Create new player
   *
   * @param playerRequest  (optional)
   * @return Created response (status code 201)
   */
  @ApiOperation(value = "", nickname = "createPlayer", notes = "Create new player", response = PlayerResponse.class, tags = {
      "player",})
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Created response", response = PlayerResponse.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/players",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<PlayerResponse> createPlayer(
      @ApiParam(value = "") @Valid @RequestBody(required = false) PlayerRequest playerRequest) {
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
   * DELETE /players/{playerId}
   * Remove player
   *
   * @param playerId  (required)
   * @return Ok response (status code 200)
   *         or Not Found (status code 404)
   *         or Forbidden (status code 403)
   */
  @ApiOperation(value = "", nickname = "deletePlayer", notes = "Remove player", tags = {"player",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 403, message = "Forbidden")})
  @RequestMapping(
      method = RequestMethod.DELETE,
      value = "/players/{playerId}"
  )
  default ResponseEntity<Void> deletePlayer(
      @ApiParam(value = "", required = true) @PathVariable("playerId") Long playerId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /players/{playerId}
   * Get single player
   *
   * @param playerId  (required)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "getPlayer", notes = "Get single player", response = PlayerRequest.class, tags = {
      "player",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = PlayerRequest.class)})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/players/{playerId}",
      produces = {"application/json"}
  )
  default ResponseEntity<PlayerRequest> getPlayer(
      @ApiParam(value = "", required = true) @PathVariable("playerId") Long playerId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"name\" : \"name\", \"rating\" : 0 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /players
   * List all player
   *
   * @param offset Pagination parameter for list operations (optional)
   * @param limit Pagination parameter for list operations (optional)
   * @param sortBy Order by field parameter for list operations (optional)
   * @param sortOrder Sort by ASC|DESC parameter for list operations (optional)
   * @return Successful response (status code 200)
   */
  @ApiOperation(value = "", nickname = "listPlayers", notes = "List all player", response = PlayerResponse.class, responseContainer = "List", tags = {
      "player",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful response", response = PlayerResponse.class, responseContainer = "List")})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/players",
      produces = {"application/json"}
  )
  default ResponseEntity<List<PlayerResponse>> listPlayers(
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
   * PUT /players/{playerId}
   * Update single player
   *
   * @param playerId  (required)
   * @param playerRequest  (optional)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "updatePlayer", notes = "Update single player", response = PlayerResponse.class, tags = {
      "player",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = PlayerResponse.class)})
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/players/{playerId}",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<PlayerResponse> updatePlayer(
      @ApiParam(value = "", required = true) @PathVariable("playerId") Long playerId,
      @ApiParam(value = "") @Valid @RequestBody(required = false) PlayerRequest playerRequest) {
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
