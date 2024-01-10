package ma.fstt.authenticationservice.Mapper;

import ma.fstt.authenticationservice.DTO.SignUpDto;
import ma.fstt.authenticationservice.DTO.UserDto;
import ma.fstt.authenticationservice.Persistence.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
