package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        UserMapper userMapper = new UserMapper();
        User user = userMapper.mapToUser(userDTO);
        User userSaved =  userRepo.save(user);
      return userMapper.mapToUserDTO(userSaved);
    }

    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }
}
