package ru.danil42russia.hbfdb.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import ru.danil42russia.hbfdb.service.MyUserDetailsService

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
        private val myUserDetailsService: MyUserDetailsService
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/user")
            .permitAll()
        .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
        .and()
            .httpBasic()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .csrf()
            .disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(BCryptPasswordEncoder())
    }
}