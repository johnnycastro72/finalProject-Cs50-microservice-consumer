package com.santiagoposadag.cs50.receiverconsumer.helpers;

import com.santiagoposadag.cs50.receiverconsumer.collections.User;
import com.santiagoposadag.cs50.receiverconsumer.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMappers {

    /**
     * > It takes a User entity and returns a UserDto
     *
     * @return A function that takes a User and returns a UserDto
     */
    public Function<User, UserDto> fromUserEntityToDto() {
        return user -> {
            var userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setLastName(user.getLastName());
            userDto.setRoutingKey(user.getRoutingKey());
            return userDto;
        };
    }

    /**
     * > It takes a UserDto and returns a User
     *
     * @return A function that takes a UserDto and returns a User.
     */
    public Function<UserDto, User> fromUserDtoToEntity() {
        return userDto -> {
            var user = new User();
            user.setId(userDto.getId());
            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            user.setRoutingKey(userDto.getRoutingKey());
            return user;
        };
    }
}
