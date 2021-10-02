package com.kalibek.ttleague.security.filter;

import static org.springframework.util.ObjectUtils.isEmpty;

import com.google.common.net.HttpHeaders;
import com.kalibek.ttleague.security.service.JWTTokenService;
import java.io.IOException;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JWTTokenFilter extends OncePerRequestFilter {

  private final JWTTokenService JWTTokenService;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain) throws ServletException, IOException {
    // Get authorization header and validate
    final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (isEmpty(header) || !header.startsWith("Bearer ")) {
      chain.doFilter(request, response);
      return;
    }

    // Get jwt token and validate
    final String token = header.split(" ")[1].trim();
    if (!JWTTokenService.verify(token)) {
      chain.doFilter(request, response);
      return;
    }

    // Get user identity and set it on the spring security context
    UserDetails userDetails = new User(
        JWTTokenService.getLogin(token),
        "",
        List.of(new SimpleGrantedAuthority(JWTTokenService.getRole(token)))
    );

    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
        userDetails, null,
        userDetails.getAuthorities()
    );

    authentication
        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(request, response);
  }
}
