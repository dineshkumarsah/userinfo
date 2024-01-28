package com.codedecode.userinfo.mapper;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDTO(User user){
     return new UserDTO(
             user.getUserId(),
              user.getUserName(),
              user.getUserPassword(),
              user.getAddress(),
              user.getCity()
     );
    }
    public static User mapToUser(UserDTO userDTO){
        return new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getUserPassword(),
                userDTO.getAddress(),
                userDTO.getCity()
        );
    }
}
