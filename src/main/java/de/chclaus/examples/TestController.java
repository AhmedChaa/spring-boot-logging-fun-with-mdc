package de.chclaus.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Christian Claus (ch.claus@me.com)
 */
@Controller
public class TestController {

  private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

  @ResponseBody
  @RequestMapping("/")
  public String index() {
    LOG.info("foo called!");
    return "foo";
  }
}
