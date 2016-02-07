//package com.ecommerce.repository;
//
//import com.ecommerce.model.User;
//import com.ecommerce.model.UserRole;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by elena on 06.02.16.
// */
//@Repository
//public class UserRepository {
//    private static final Map<String, User> DATA = new HashMap<String, User>() {{
//        List<UserRole> roles1 = new ArrayList<UserRole>();
//        roles1.add(UserRole.USER);
//        List<UserRole> roles2 = new ArrayList<UserRole>();
//        roles2.add(UserRole.USER);
//        roles2.add(UserRole.ADMIN);
//        put("user", new User().setLogin("user").setPassword("password").setRoles(roles1));
//        put("admin", new User().setLogin("admin").setPassword("password").setRoles(roles2));
//    }};
//
//    public User getUser(String login) {
//        return DATA.get(login);
//    }
//}
