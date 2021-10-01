package com.kalibek.ttleague.security.service;

import com.kalibek.ttleague.model.entity.UserEntity;
import com.kalibek.ttleague.model.repo.UserRepo;
import com.kalibek.ttleague.security.exception.PasswordDoesNotMatchException;
import com.kalibek.ttleague.security.exception.UserNotFoundException;
import com.kalibek.ttleague.security.model.LoginRequest;
import com.kalibek.ttleague.security.model.RefreshRequest;
import com.kalibek.ttleague.security.model.TokenResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepo userRepo;
  private final BCryptPasswordEncoder bcryptPasswordEncoder;
  private final JWTTokenService jwtTokenService;

  public User getByLogin(String login) {
    UserEntity userEntity = findByLogin(login);
    return new User(
        userEntity.getLogin(), "", List.of(new SimpleGrantedAuthority(userEntity.getRole()))
    );
  }

  public UserEntity findByLogin(String login) {
    return userRepo.findByLogin(login).orElseThrow(UserNotFoundException::new);
  }

  public TokenResponse authTokenPost(LoginRequest loginRequest) {
    UserEntity user = findByLogin(loginRequest.getLogin());
    if (bcryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
      return new TokenResponse(
          jwtTokenService.encode(user),
          jwtTokenService.encode(user) //TODO generate refresh token
      );
    }
    throw new PasswordDoesNotMatchException();
  }

  public TokenResponse authTokenRefreshPost(RefreshRequest refreshRequest) {
    // TODO
    return null;
  }
}
