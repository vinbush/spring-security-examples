package org.springframework.security.samples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public class AccessDecider {
  public boolean canAccessNumber(Authentication authentication, int number) {
    return number != 13 || authentication.getAuthorities().stream().anyMatch(ga -> ga.getAuthority().equals("ROLE_ADMIN"));
  }
}
