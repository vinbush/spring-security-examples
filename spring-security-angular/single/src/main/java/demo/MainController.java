package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
  @GetMapping("/user")
  @ResponseBody
  public Principal user(Principal user) {
    return user;
  }

  @GetMapping("/resource")
  @ResponseBody
  public Map<String, Object> home(Principal user) {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("id", user.getName());
    model.put("content", "Hello World");
    return model;
  }

  @GetMapping(value = "/{path:[^\\.]*}")
  public String redirect() {
    return "forward:/";
  }
}
