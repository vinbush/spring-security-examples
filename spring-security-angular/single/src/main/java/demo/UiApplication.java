package demo;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.util.Password;

@SpringBootApplication
public class UiApplication {
    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }

  @Bean
  public CommandLineRunner commandLineRunner() {
    return new CommandLineRunner() {
      @Autowired
      private UserRepository userRepository;

      @Autowired
      private PasswordEncoder encoder;

      @Override
      public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("vincent");
        user.setPassword(encoder.encode("password"));
        userRepository.save(user);
      }
    };
  }

  @Bean
  public PasswordEncoder encoder() {
      return new BCryptPasswordEncoder(16);
  }

}
