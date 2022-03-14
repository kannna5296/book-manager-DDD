package com.book.manager.bookmanager.presentation.config

import com.book.manager.bookmanager.application.service.AuthenticationService
import com.book.manager.bookmanager.application.service.security.BookManagerUserDetailsService
import com.book.manager.bookmanager.domain.enum.RoleType
import com.book.manager.bookmanager.presentation.handler.BookManagerAccessDeniedHandler
import com.book.manager.bookmanager.presentation.handler.BookManagerAuthenticationEntryPoint
import com.book.manager.bookmanager.presentation.handler.BookManagerAuthenticationFailureHandler
import com.book.manager.bookmanager.presentation.handler.BookManagerAuthenticationSuccessHandler
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@EnableWebSecurity
class SecurityConfig(private val authenticationService: AuthenticationService) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        val configurationSource = http.authorizeRequests()
            .mvcMatchers("/login").permitAll()
            .mvcMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin() //ユーザ名、パスワードでのログインを有効化
            .loginProcessingUrl("/login")
            .usernameParameter("email")
            .passwordParameter("pass")
            //認証成功時の動作
            .successHandler(BookManagerAuthenticationSuccessHandler())
            //認証失敗時の動作
            .failureHandler(BookManagerAuthenticationFailureHandler())
            .and()
            .exceptionHandling()
            //未認証時の動作
            .authenticationEntryPoint(BookManagerAuthenticationEntryPoint())
            //未認可時の動作
            .accessDeniedHandler(BookManagerAccessDeniedHandler())
            .and()
            .cors()
            .configurationSource(corsConfigurationSource())
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(BookManagerUserDetailsService(authenticationService))
            .passwordEncoder(BCryptPasswordEncoder())
    }

    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)
        corsConfiguration.addAllowedOrigin("http://localhost:8081")
        corsConfiguration.allowCredentials = true

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsConfigurationSource
    }
}