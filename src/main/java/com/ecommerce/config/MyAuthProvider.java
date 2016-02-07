//package com.ecommerce.config;
//
//import com.ecommerce.model.User;
//import com.ecommerce.repository.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
///**
// * Created by elena on 06.02.16.
// */
//@Component
//public class MyAuthProvider implements AuthenticationProvider {
//
//    @Autowired
//    UserDao userRepository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String login = authentication.getName();
//     String password = (String) authentication.getCredentials();
//      User user = userRepository.findUserByEmail(login);
//     if (user == null) {
//          throw new BadCredentialsException("User not found");
//      }
//     if(!password.equals(user.getPassword())) {
//         throw new BadCredentialsException("Pass not match");
//             }
//
//        return new UsernamePasswordAuthenticationToken(user, password, user.getRoles());
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//}
