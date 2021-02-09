package com.stapring.springboot.config.auth;

import com.stapring.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/img/**","/fonts/**","/scss/**","/jquery/**", "/css/**", "/vendor/**", "/image/**", "/js/**", "/h2-console/**", "/profile" , "/login-main","/login").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.GUEST.name())
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    //.antMatchers("/유료고객 사용 권한").hasRole(Role.PAID_MEMBER.name())
                    .anyRequest().authenticated()
                .and()
                    .oauth2Login().
                        loginPage("/login")
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}