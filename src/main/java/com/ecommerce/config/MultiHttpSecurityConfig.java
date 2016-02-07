//package com.ecommerce.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
//* Created by elena on 06.02.16.
//*/
//@EnableWebSecurity
//public class MultiHttpSecurityConfig {
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
//    }
//
//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .antMatcher("/products/**")
//                    .authorizeRequests()
//                    .anyRequest().permitAll()
//                    .and()
//                    .httpBasic();
//
//            http
//                    .csrf().disable();
////            http.csrf()
////                    .csrfTokenRepository(csrfTokenRepository());
//
//        }
////        private CsrfTokenRepository csrfTokenRepository(){
////            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
////            repository.setSessionAttributeName("_csrf");
////
////            return repository;
////        }
//    }
//
//    @Configuration
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin();
//
//        }
//    }
//
//}
