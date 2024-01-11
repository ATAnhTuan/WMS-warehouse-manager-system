package com.wms.warehouse.controller;

import com.wms.warehouse.entity.RoleEntity;
import com.wms.warehouse.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@Tag(name = "RoleController")
public class RoleController {
    final private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/Role")
    public ResponseEntity<List<RoleEntity>> getAllRole() {
        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }
    @PostMapping("/Role")
    public ResponseEntity<RoleEntity> createNewRole(@RequestBody RoleEntity role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
    @GetMapping("/Role/Detail/{id}")
    public ResponseEntity<Optional> getRole(@PathVariable Long id) {
        return new ResponseEntity<>(roleService.getRole(id),HttpStatus.OK);
    }
    @DeleteMapping("/Role/{id}")
    public ResponseEntity<RoleEntity> deleteRole(@PathVariable Long id) {
        return new ResponseEntity(roleService.deleteRole(id),HttpStatus.OK);
    }
    @PutMapping("/Role/{id}")
    public ResponseEntity<RoleEntity> updateRole(@PathVariable Long id, @RequestBody RoleEntity role) {
        return new ResponseEntity<>(roleService.updateRole(id,role), HttpStatus.OK);
    }
}
