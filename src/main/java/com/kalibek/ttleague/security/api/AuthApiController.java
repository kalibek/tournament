package com.kalibek.ttleague.security.api;

import com.kalibek.ttleague.security.model.LoginRequest;
import com.kalibek.ttleague.security.model.RefreshRequest;
import com.kalibek.ttleague.security.model.TokenResponse;
import com.kalibek.ttleague.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.authenticationAuthorization.base-path:/api/v1.0.0}")
@RequiredArgsConstructor
public class AuthApiController implements AuthApi {

  private final UserService userService;

  @Override
  public ResponseEntity<TokenResponse> authTokenPost(LoginRequest loginRequest) {
    return ResponseEntity.ok(userService.authTokenPost(loginRequest));
  }

  @Override
  public ResponseEntity<TokenResponse> authTokenRefreshPost(RefreshRequest refreshRequest) {
    return ResponseEntity.ok(userService.authTokenRefreshPost(refreshRequest));
  }
}
