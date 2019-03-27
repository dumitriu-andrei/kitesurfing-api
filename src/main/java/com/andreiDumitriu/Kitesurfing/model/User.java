package com.andreiDumitriu.Kitesurfing.model;

import lombok.Data;

import java.util.Set;
import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @Transient
    private String passwordConfirmation;

    @ManyToMany
    private Set<Role> roles;



}
