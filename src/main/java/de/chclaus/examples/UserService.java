package de.chclaus.examples;

import org.springframework.stereotype.Service;

/**
 * @author chclaus (ch.claus@me.com)
 */
@Service
public class UserService {

  public String findUsernameByToken(String authToken) {
    return "myImpressiveUsername";
  }
}
