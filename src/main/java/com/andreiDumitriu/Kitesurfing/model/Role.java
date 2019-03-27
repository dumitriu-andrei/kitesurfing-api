package com.andreiDumitriu.Kitesurfing.model;


import lombok.Data;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String name){
        this.name = name;

    }

}
