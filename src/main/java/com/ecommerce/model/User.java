package com.ecommerce.model;

import javax.persistence.*;

/**
 * Class {@link User}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 08.10.15
 */

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {

    private Long id;
    private String email;
    private String password;
    private UserRole roles;

    public User() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "email", nullable = false, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    @Enumerated(EnumType.STRING)
    public UserRole getRoles() {
        return roles;
    }

    public void setRoles(UserRole roles) {
        this.roles = roles;
    }
}
