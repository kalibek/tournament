package com.kalibek.ttleague.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kalibek.ttleague.domain.entity.UserEntity;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JWTTokenService {

  @Value("${spring.app.jwt.secret}")
  private String secretKey;
  @Value("${spring.app.jwt.ttl.access:60}")
  private int accessTokenTTL;
  @Value("${spring.app.jwt.ttl.refresh:3600}")
  private int refreshTokenTTL;

  private static final String LOGIN = "login";
  private static final String ROLE = "role";
  private static final String ISSUER = "table-tennis-league.com";
  private static final String TOKEN_TYPE = "type";
  private static final String ACCESS_TOKEN = "access_token";
  private static final String REFRESH_TOKEN = "refresh_token";

  public String accessToken(UserEntity user) {
    return encode(user, ACCESS_TOKEN, accessTokenTTL);
  }

  public String refreshToken(UserEntity user) {
    return encode(user, REFRESH_TOKEN, refreshTokenTTL);
  }

  private String encode(UserEntity userEntity, String tokenType, int seconds) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    Date date = Date.from(
        LocalDateTime.now().plus(seconds, ChronoUnit.SECONDS).atZone(
            ZoneId.systemDefault()).toInstant());

    return JWT.create()
        .withClaim(TOKEN_TYPE, tokenType)
        .withClaim(LOGIN, userEntity.getLogin())
        .withClaim(ROLE, userEntity.getRole())
        .withIssuer(ISSUER)
        .withExpiresAt(date)
        .sign(algorithm);
  }

  public Boolean verify(String token) {
    return getJwt(token)
        .map(jwt -> jwt.getExpiresAt().after(new Date()))
        .orElse(false);
  }

  public String getLogin(String token) {
    return getJwt(token)
        .map(jwt -> jwt.getClaim(LOGIN).asString())
        .orElse("");
  }

  public String getRole(String token) {
    return getJwt(token)
        .map(jwt -> jwt.getClaim(LOGIN).asString())
        .orElse("ROLE_ANONYMOUS");
  }

  private Optional<DecodedJWT> getJwt(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(ISSUER)
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      return Optional.of(jwt);
    } catch (JWTVerificationException e) {
      return Optional.empty();
    }
  }

}
