package com.kalibek.ttleague.security.config;

import com.kalibek.ttleague.security.filter.JWTTokenFilter;
import com.kalibek.ttleague.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    jsr250Enabled = true,
    prePostEnabled = true
)
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JWTTokenFilter jwtTokenFilter;
  private final UserService userService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService::getByLogin);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()

        // don't create a session for this configuration
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()

        // allow tokens
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/v1.0.0/auth/token").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1.0.0/players/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1.0.0/series/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1.0.0/tournaments/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1.0.0/groups/**").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1.0.0/matches/**").permitAll()
        .and()

        // secure all the paths
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()

        .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
  }


}
