package com.kalibek.ttleague.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kalibek.ttleague.model.entity.UserEntity;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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

  private static final String LOGIN = "login";
  private static final String ROLE = "role";
  private static final String ISSUER = "ISSUER";

  public String encode(UserEntity userEntity) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    Date date = Date.from(
        LocalDateTime.now().plus(1, ChronoUnit.HOURS).atZone(
            ZoneId.systemDefault()).toInstant());

    return JWT.create()
        .withClaim(LOGIN, userEntity.getLogin())
        .withClaim(ROLE, userEntity.getRole())
        .withIssuer(ISSUER)
        .withExpiresAt(date)
        .sign(algorithm);
  }

  public Boolean verify(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(ISSUER)
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      return jwt.getExpiresAt().after(new Date());
    } catch (JWTVerificationException e) {
      return false;
    }
  }

  public String getLogin(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(ISSUER)
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      return jwt.getClaim(LOGIN).asString();
    } catch (JWTVerificationException e) {
      return null;
    }
  }

  public String getRole(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(ISSUER)
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      return jwt.getClaim(ROLE).asString();
    } catch (JWTVerificationException e) {
      return null;
    }
  }

}
