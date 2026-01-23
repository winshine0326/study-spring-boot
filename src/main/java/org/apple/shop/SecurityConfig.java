package org.apple.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf((csrf) -> csrf.disable()); // () -> {} << lambda expression
    //csrf 공격 예방(jwt 사용시에는 꺼도됨 :: 그냥 토큰을 header에 담아서 보내주면 해결 가능하기 때문)
    http.authorizeHttpRequests((authorize) ->
            authorize.requestMatchers("/**").permitAll()
    );
    return http.build();
  }
}