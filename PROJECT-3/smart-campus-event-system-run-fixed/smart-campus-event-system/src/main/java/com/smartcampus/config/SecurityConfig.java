package com.smartcampus.config;

import com.smartcampus.entity.Role;
import com.smartcampus.entity.User;
import com.smartcampus.entity.Event;
import com.smartcampus.repository.EventRepository;
import com.smartcampus.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repo) {
        return email -> {
            User user = repo.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            if (!user.isVerified()) {
                throw new DisabledException("Please verify OTP before login");
            }

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole().name())
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/css/**",
                    "/js/**",
                    "/images/**",
                    "/register",
                    "/verify",
                    "/login",
                    "/",
                    "/events",
                    "/api/**",
                    "/h2-console/**"
                ).permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            )
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }

    @Bean
    public CommandLineRunner createDefaultAdmin(UserRepository repo, EventRepository eventRepo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByEmail("admin@campus.com").isEmpty()) {
                User admin = new User();
                admin.setName("Campus Admin");
                admin.setEmail("admin@campus.com");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole(Role.ADMIN);
                admin.setVerified(true);
                repo.save(admin);
            }
            if(eventRepo.count()==0){
                eventRepo.save(new Event("AI Innovation Workshop","CSE","Workshop",java.time.LocalDate.parse("2026-05-15"),"Auditorium A",120,"/images/event1.svg","Hands-on AI tools, ML workflow, and real campus use cases."));
                eventRepo.save(new Event("Cultural Fest Night","Arts","Cultural",java.time.LocalDate.parse("2026-05-20"),"Open Stage",300,"/images/event2.svg","Premium vintage cultural evening with music, dance, and student performances."));
                eventRepo.save(new Event("Cyber Security Seminar","IT","Seminar",java.time.LocalDate.parse("2026-05-25"),"Seminar Hall 2",150,"/images/event3.svg","Expert session on privacy, safe coding, cyber hygiene, and modern threats."));
                eventRepo.save(new Event("Startup Pitch Carnival","MBA","Competition",java.time.LocalDate.parse("2026-06-02"),"Innovation Lab",80,"/images/event1.svg","Pitch ideas, meet mentors, and learn how campus startups are built."));
            }
        };
    }
}
