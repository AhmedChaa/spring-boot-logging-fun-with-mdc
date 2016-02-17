package de.chclaus.examples;

import org.jboss.logging.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Christian Claus (ch.claus@me.com)
 */
@Component
public class LoggingFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // do nothing.
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      UserDetails principal = (UserDetails) authentication.getPrincipal();
      MDC.put("username", principal.getUsername());
    }

    filterChain.doFilter(servletRequest, servletResponse);
    MDC.remove("username");
  }

  @Override
  public void destroy() {
    // do nothing.
  }
}
