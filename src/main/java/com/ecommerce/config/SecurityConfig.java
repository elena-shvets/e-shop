//package com.ecommerce.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
//* Created by elena on 06.02.16.
//*/
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").denyAll()
//                .antMatchers("/hello").hasRole("ADMIN")
//                .anyRequest().authenticated();
////                .and();
////                .formLogin().loginPage("/login").permitAll().and()
////                .logout().logoutUrl("/logout").logoutSuccessUrl("/test");
//    }
//
//    @Override
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//
//        //  .inMemoryAuthentication()
//
//        //  .withUser("user").password("password").roles("USER").and()
//
//        //  .withUser("admin").password("password").roles("USER", "ADMIN");
//
//    }
//
//
//}
