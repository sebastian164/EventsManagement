package com.innova.events.application.service.auth;

import com.innova.events.infrastructure.persistence.entity.UserEntity;
import com.innova.events.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String[] roles = Arrays.stream(userEntity.getRole().getName().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(!userEntity.getActive())
                .disabled(!userEntity.getActive())
                .build();
    }

    private String[] getAuthorities(String role) {
        switch (role) {
            case "Administrador":
                return new String[] {"CREATE_EVENT", "EDIT_EVENT", "DELETE_EVENT", "VIEW_EVENT"};
            case "Organizador":
                return new String[] {"CREATE_EVENT", "EDIT_EVENT"};
            case "Asistente":
                return new String[] {"VIEW_EVENT"};
            default:
                return new String[] {};
        }
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority: this.getAuthorities(role)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }

        return authorities;
    }
}