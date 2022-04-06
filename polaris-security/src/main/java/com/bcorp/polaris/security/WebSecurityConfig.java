package com.bcorp.polaris.security;

import com.bcorp.polaris.security.jwt.AuthTokenFilter;
import com.bcorp.polaris.security.jwt.TokenAuthenticationEntryPoint;
import com.bcorp.polaris.security.service.CoreUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    CoreUserDetailsService coreUserDetailsService;

    @Autowired
    private TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable().cors().disable()
                .authorizeRequests((authz) -> authz

                        .antMatchers(
                                "/api/v1/user/register",
                                "/api/v1/user/login",
                                "/api/v1/books/**")
                        .permitAll()
                        .antMatchers("/author/api/**").hasRole("AUTHOR")
                        .anyRequest().authenticated())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling((exceptions) -> exceptions
                        .authenticationEntryPoint(tokenAuthenticationEntryPoint)
                )
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {
        authenticationManagerBuilder.userDetailsService(coreUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter()
    {
        return new AuthTokenFilter();
    }

}
