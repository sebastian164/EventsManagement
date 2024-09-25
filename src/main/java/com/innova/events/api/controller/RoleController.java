package com.innova.events.api.controller;

import com.innova.events.application.service.role.RoleService;
import com.innova.events.domain.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
        RoleDTO createdRole = roleService.save(roleDTO);
        return ResponseEntity.ok(createdRole);
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id){
        RoleDTO rol = roleService.findById(id);
        return rol != null ? ResponseEntity.ok(rol): ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteRole(@PathVariable Long id){
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}