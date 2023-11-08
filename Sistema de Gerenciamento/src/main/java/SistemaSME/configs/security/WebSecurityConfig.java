/*package SistemaSME.configs.security;


import SistemaSME.services.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Autowired
        private SSUserDetailsService userDetailsService;
        
        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/admin").hasAuthority("ADMIN")
                    .anyRequest().authenticated())
                    .formLogin().loginPage("/login").permitAll()
                    .and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login").permitAll()
                    .and()
                    .httpBasic();
            http.csrf().disable();
            http.headers().frameOptions().disable();

            return http.build();

        }

        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder, SSUserDetailsService ssUserDetailsService) throws Exception{
      /*  auth.inMemoryAuthentication()
                .withUser("alisson").password(passwordEncoder().encode("alisson2020"))
                .authorities("ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("1234")).authorities("USER");*/

    /*        return http.getSharedObject(AuthenticationManagerBuilder.class)
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder)
                    .and()
                    .build();

        }
    }*/