package com.kalibek.ttleague.security.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.kalibek.ttleague.domain.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = {JWTTokenService.class},
    properties = "spring.app.jwt.secret=test"
)
class JWTTokenServiceTest {

  @Autowired
  private JWTTokenService jwtTokenService;
  private String token;

  @BeforeEach
  void setup() {
    UserEntity userEntity = new UserEntity();
    userEntity.setLogin("test");
    userEntity.setRole("test_role");
    token = jwtTokenService.accessToken(userEntity);
  }

  @Test
  void encodeShouldReturnValidToken() {

    assertThat(jwtTokenService.verify(token)).isTrue();

  }

  @Test
  void encodeShouldReturnName() {

    assertThat(jwtTokenService.getLogin(token)).isEqualTo("test");

  }

  @Test
  void encodeShouldReturnRole() {

    assertThat(jwtTokenService.getRole(token)).isEqualTo("test_role");

  }

}