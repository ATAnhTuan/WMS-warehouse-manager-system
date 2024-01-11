package com.wms.warehouse.controller;

import com.wms.warehouse.entity.UserEntity;
import com.wms.warehouse.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "UserController")
public class UserController {
    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/User")
    public ResponseEntity<List<UserEntity>> getAllUser () {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @PostMapping("/User")
    public ResponseEntity<UserEntity> createUser (@RequestBody UserEntity userEntity) {
        return new ResponseEntity<>(userService.createUser(userEntity), HttpStatus.CREATED);
    }
    @GetMapping("/User/Detail/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) throws Exception {
        return  new ResponseEntity<>(userService.getUser(id).orElseThrow( () -> new Exception("Can not found this ID:" + id))
                ,HttpStatus.NO_CONTENT);
    }
    @PutMapping("/User/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestParam String  rolename) {
        return new ResponseEntity(userService.updateUser(id,rolename), HttpStatus.NO_CONTENT);
    }
}
