package com.workintech.ecommerce.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "role", schema = "ecommerceweb")
public class Role implements GrantedAuthority { //grantedAuthority yetkilendirme

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "authority")
    private String authority;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> users;
    public void addUser(User user){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(user);
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
