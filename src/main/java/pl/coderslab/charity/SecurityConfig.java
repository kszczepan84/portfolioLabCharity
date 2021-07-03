package pl.coderslab.charity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/").permitAll()
                .antMatchers("/user/successLogin").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login")
//                .accessDeniedHandler()
                .and()
                .formLogin()
                .defaultSuccessUrl("/successLogin", true)
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .failureUrl("/login-error")
                .and()
                .logout()
                .permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");
    }

}
