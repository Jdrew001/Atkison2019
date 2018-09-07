package com.atkison.atkison2018.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public SecurityConfiguration() {
        super();
    }

    @Override
    @Bean
   public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withUsername("dtatkison").password("{noop}password").roles("ADMIN").build();

        UserDetails user2 = User.withUsername("izzybeth").password("{noop}password").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2);
   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/dashboard/**").authenticated()
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login").failureForwardUrl("/loginfailure")
                .and().logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
    }
}
