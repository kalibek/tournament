package com.kalibek.ttleague.rest.api;

import com.kalibek.ttleague.rest.model.GroupPlayerResponse;
import com.kalibek.ttleague.rest.model.GroupRequest;
import com.kalibek.ttleague.rest.model.GroupResponse;
import com.kalibek.ttleague.rest.model.MatchResponse;
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
@Api(value = "groups", description = "the groups API")
public interface GroupsApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /groups/{groupId}/players/{playerId}/seedings
   * add player to group
   *
   * @param groupId  (required)
   * @param playerId  (required)
   * @return Ok response (status code 201)
   */
  @ApiOperation(value = "", nickname = "addPlayerToGroup", notes = "add player to group", response = GroupPlayerResponse.class, tags = {
      "seeding",})
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Ok response", response = GroupPlayerResponse.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/groups/{groupId}/players/{playerId}/seedings",
      produces = {"application/json"}
  )
  default ResponseEntity<GroupPlayerResponse> addPlayerToGroup(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId,
      @ApiParam(value = "", required = true) @PathVariable("playerId") Long playerId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"groupId\" : 0, \"startingPosition\" : 1, \"playerId\" : 6 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * DELETE /groups/{groupId}
   * Remove series
   *
   * @param groupId  (required)
   * @return Ok response (status code 200)
   *         or Not Found (status code 404)
   *         or Forbidden (status code 403)
   */
  @ApiOperation(value = "", nickname = "deleteGroup", notes = "Remove series", tags = {"groups",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 403, message = "Forbidden")})
  @RequestMapping(
      method = RequestMethod.DELETE,
      value = "/groups/{groupId}"
  )
  default ResponseEntity<Void> deleteGroup(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * DELETE /groups/{groupId}/players/{playerId}/seedings
   * Remove series
   *
   * @param groupId  (required)
   * @param playerId  (required)
   * @return Ok response (status code 200)
   *         or Not Found (status code 404)
   *         or Forbidden (status code 403)
   */
  @ApiOperation(value = "", nickname = "deletePlayerFromGroup", notes = "Remove series", tags = {
      "seeding",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 403, message = "Forbidden")})
  @RequestMapping(
      method = RequestMethod.DELETE,
      value = "/groups/{groupId}/players/{playerId}/seedings"
  )
  default ResponseEntity<Void> deletePlayerFromGroup(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId,
      @ApiParam(value = "", required = true) @PathVariable("playerId") Long playerId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /groups/{groupId}
   * Get single series
   *
   * @param groupId  (required)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "getGroup", notes = "Get single series", response = GroupResponse.class, tags = {
      "groups",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = GroupResponse.class)})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}",
      produces = {"application/json"}
  )
  default ResponseEntity<GroupResponse> getGroup(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"runDate\" : \"2000-01-23T04:56:07.000+00:00\", \"tournamentId\" : 0, \"position\" : 6 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /groups/{groupId}/players/{playerId}/seedings
   * get player of group
   *
   * @param groupId  (required)
   * @param playerId  (required)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "getGroupPlayer", notes = "get player of group", response = GroupPlayerResponse.class, tags = {
      "seeding",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = GroupPlayerResponse.class)})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}/players/{playerId}/seedings",
      produces = {"application/json"}
  )
  default ResponseEntity<GroupPlayerResponse> getGroupPlayer(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId,
      @ApiParam(value = "", required = true) @PathVariable("playerId") Long playerId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"groupId\" : 0, \"startingPosition\" : 1, \"playerId\" : 6 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /groups/{groupId}/players
   * List all player in group
   *
   * @param groupId  (required)
   * @param offset Pagination parameter for list operations (optional)
   * @param limit Pagination parameter for list operations (optional)
   * @param sortBy Order by field parameter for list operations (optional)
   * @param sortOrder Sort by ASC|DESC parameter for list operations (optional)
   * @return Successful response (status code 200)
   */
  @ApiOperation(value = "", nickname = "listGroupPlayers", notes = "List all player in group", response = GroupPlayerResponse.class, responseContainer = "List", tags = {
      "groups",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful response", response = GroupPlayerResponse.class, responseContainer = "List")})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}/players",
      produces = {"application/json"}
  )
  default ResponseEntity<List<GroupPlayerResponse>> listGroupPlayers(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId,
      @ApiParam(value = "Pagination parameter for list operations") @Valid @RequestParam(value = "offset", required = false) Integer offset,
      @ApiParam(value = "Pagination parameter for list operations") @Valid @RequestParam(value = "limit", required = false) Integer limit,
      @ApiParam(value = "Order by field parameter for list operations") @Valid @RequestParam(value = "sortBy", required = false) String sortBy,
      @ApiParam(value = "Sort by ASC|DESC parameter for list operations", allowableValues = "ASC, DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"groupId\" : 0, \"startingPosition\" : 1, \"playerId\" : 6 }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * GET /groups/{groupId}/matches
   * List all matches in group
   *
   * @param groupId  (required)
   * @param offset Pagination parameter for list operations (optional)
   * @param limit Pagination parameter for list operations (optional)
   * @param sortBy Order by field parameter for list operations (optional)
   * @param sortOrder Sort by ASC|DESC parameter for list operations (optional)
   * @return Successful response (status code 200)
   */
  @ApiOperation(value = "", nickname = "listMatches", notes = "List all matches in group", response = MatchResponse.class, responseContainer = "List", tags = {
      "groups",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successful response", response = MatchResponse.class, responseContainer = "List")})
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/groups/{groupId}/matches",
      produces = {"application/json"}
  )
  default ResponseEntity<List<MatchResponse>> listMatches(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId,
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
   * PUT /groups/{groupId}
   * Update single series
   *
   * @param groupId  (required)
   * @param groupRequest  (optional)
   * @return Ok response (status code 200)
   */
  @ApiOperation(value = "", nickname = "updateGroup", notes = "Update single series", response = GroupResponse.class, tags = {
      "groups",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Ok response", response = GroupResponse.class)})
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/groups/{groupId}",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<GroupResponse> updateGroup(
      @ApiParam(value = "", required = true) @PathVariable("groupId") Long groupId,
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

}
