package cz.uhk.kppro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SharedConfig {

// mame aby se nam nezacyklilo

    @Bean
    public PasswordEncoder passwordEncoder() {  // algoritmus v SecurityConfig
        return new BCryptPasswordEncoder();
    }
}