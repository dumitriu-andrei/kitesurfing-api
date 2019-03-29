package com.andreiDumitriu.Kitesurfing.model;

import lombok.Data;


import java.util.HashSet;
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

    @ManyToMany
    @JoinTable(name="favorites",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(name="location_id",referencedColumnName = "id"))
    private Set<Location> locations = new HashSet<>();


    @Transient
    private String passwordConfirmation;

    @ManyToMany
    private Set<Role> roles;

    public User() {

    }


}
