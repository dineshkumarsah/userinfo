package com.codedecode.userinfo.controller;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
      UserDTO savedUser =   userService.addUser(userDTO);
     return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        Optional <User> userOptional =userService.getUserById(id);
        if(userOptional.isPresent()){
            UserMapper mapper = new UserMapper();
            UserDTO userDTO =  mapper.mapToUserDTO(userOptional.get());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }else {
           return new  ResponseEntity<>(null,HttpStatus.NOT_FOUND ) ;
        }
    }  
}
