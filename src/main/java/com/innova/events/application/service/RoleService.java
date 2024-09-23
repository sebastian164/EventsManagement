package com.innova.events.application.service;

import com.innova.events.domain.model.Role;
import com.innova.events.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Flux<Role> findAll() {
        return roleRepository.findAll();
    }

    public Mono<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public Mono<Role> save(Role role) {
        return roleRepository.save(role);
    }

    public Mono<Void> deleteById(Long id) {
        return roleRepository.deleteById(id);
    }
}
