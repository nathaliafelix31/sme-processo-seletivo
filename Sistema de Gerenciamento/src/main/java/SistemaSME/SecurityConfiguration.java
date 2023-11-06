package SistemaSME;


import SistemaSME.Repository.UsuarioRepository;
import SistemaSME.Service.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfiguration {
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(usuarioRepository);

    }


    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().
                antMatchers("/").permitAll()
                .antMatchers("/admin").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
      /*  auth.inMemoryAuthentication()
                .withUser("luciana").password(passwordEncoder().encode("luciana2024"))
                .authorities("ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("1234")).authorities("USER");*/

        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }
}
