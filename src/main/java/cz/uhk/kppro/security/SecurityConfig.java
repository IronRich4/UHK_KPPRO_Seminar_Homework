package cz.uhk.kppro.security;

import cz.uhk.kppro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/admin/**").hasRole("ADMIN")      // ** znamena pro /admin/, tak i /admin
                        .anyRequest().authenticated()   // user musi byt prihlasen, jinak presmerovan na prihlaseni
                )
                .formLogin(Customizer.withDefaults())     // zjednodusena forma - doporuceno
//                .formLogin((form) -> form
//                        .loginPage("/login") // Custom login page
//                        .loginProcessingUrl("/login") // Form submission URL
//                        .defaultSuccessUrl("/", true)  // FALSE znamena ze se vrati tam kam se uzivatel chtel prihlasit
//                        .permitAll()) // nepusti bez prihlaseni
                .logout(logout -> logout
                        .logoutUrl("/logout")       // kam posilame uzivatele metodou POST
                        .logoutSuccessUrl("/login?logout")      // get parametr pro vypis hlasky
                        .permitAll()
                )
                .exceptionHandling((exceptions) -> exceptions
                        .accessDeniedHandler(accessDeniedHandler()));   // presemrovano dole na 403 nize

        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.sendRedirect("/403");  // tu musime definovat v idexu
        };
    }
}