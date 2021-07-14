package com.hello.spring.security;

import com.hello.spring.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    final
    CustomAuthProvider customAuthProvider;

    @Autowired
    public SecurityConfiguration(CustomAuthProvider customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/layouts/**").hasAnyRole("USER")
                .antMatchers("/api/**").hasAnyRole("USER")
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home", true)
                .and()
            .oauth2Login()
                .loginPage("/oauthlogin")
                .defaultSuccessUrl("/home", true)
                .and()
            .logout()
                .permitAll();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthProvider);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() {
        return new MyUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsServiceBean());
        authProvider.setPasswordEncoder(getPassWordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder getPassWordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    
    //    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public AuthorizationFilter authenticationJwtTokenFilter() {
        return new AuthorizationFilter();
    }



}
