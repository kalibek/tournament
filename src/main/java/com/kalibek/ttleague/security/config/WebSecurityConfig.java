package com.kalibek.ttleague.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .addFilter(new SecurityFilter())
        .authorizeRequests()
        .antMatchers("/api/v1.0.0/auth").permitAll()
        .anyRequest().denyAll();
  }

}
