/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.1).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package com.kalibek.ttleague.security.api;

import com.kalibek.ttleague.security.model.LoginRequest;
import com.kalibek.ttleague.security.model.RefreshRequest;
import com.kalibek.ttleague.security.model.TokenResponse;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-29T18:30:01.311260+06:00[Asia/Almaty]")
@Validated
@Api(value = "auth", description = "the auth API")
public interface AuthApi {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /auth/token
   * generate token
   *
   * @param loginRequest  (optional)
   * @return Token created (status code 200)
   *         or access denied (status code 401)
   */
  @ApiOperation(value = "", nickname = "authTokenPost", notes = "generate token", response = TokenResponse.class, tags = {
      "auth",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Token created", response = TokenResponse.class),
      @ApiResponse(code = 401, message = "access denied")})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/auth/token",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<TokenResponse> authTokenPost(
      @ApiParam(value = "") @Valid @RequestBody(required = false) LoginRequest loginRequest) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"accessToken\" : \"accessToken\", \"refreshToken\" : \"refreshToken\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }


  /**
   * POST /auth/token/refresh
   * refresh token
   *
   * @param refreshRequest  (optional)
   * @return Token created (status code 200)
   *         or access denied (status code 401)
   */
  @ApiOperation(value = "", nickname = "authTokenRefreshPost", notes = "refresh token", response = TokenResponse.class, tags = {
      "auth",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Token created", response = TokenResponse.class),
      @ApiResponse(code = 401, message = "access denied")})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/auth/token/refresh",
      produces = {"application/json"},
      consumes = {"application/json"}
  )
  default ResponseEntity<TokenResponse> authTokenRefreshPost(
      @ApiParam(value = "") @Valid @RequestBody(required = false) RefreshRequest refreshRequest) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"accessToken\" : \"accessToken\", \"refreshToken\" : \"refreshToken\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

}
