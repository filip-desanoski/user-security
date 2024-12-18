package dev.desan.usersecurity.user.mapper;

import dev.desan.usersecurity.contact.mapper.ContactMapper;
import dev.desan.usersecurity.infrastructure.mapper.GeneralMapper;
import dev.desan.usersecurity.user.dto.UserDTO;
import dev.desan.usersecurity.user.dto.UserRegistrationDTO;
import dev.desan.usersecurity.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {ContactMapper.class})
public interface UserMapper extends GeneralMapper<UserDTO, User> {

    @Override
    @Mapping(target = "uuid", source = "uuid", qualifiedByName = "uuidToString")
    @Mapping(target = "contact", source = "contact")
    @Mapping(target = "roles", expression = "java(user.getRoles().stream().map(role -> role.getName().name()).collect(java.util.stream.Collectors.toSet()))")
    UserDTO entityToDto(User user);

    @Override
    @Mapping(target = "uuid", source = "uuid", qualifiedByName = "stringToUuid")
    @Mapping(target = "contact", source = "contact")
    @Mapping(target = "roles", ignore = true)
    User dtoToEntity(UserDTO userDTO);

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "contact.firstName", source = "firstName")
    @Mapping(target = "contact.lastName", source = "lastName")
    @Mapping(target = "contact.uuid", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User registrationToUser(UserRegistrationDTO registrationDTO);

    @Mapping(target = "firstName", source = "contact.firstName")
    @Mapping(target = "lastName", source = "contact.lastName")
    @Mapping(target = "password", ignore = true)
    UserRegistrationDTO userToRegistration(User user);

    @Named("uuidToString")
    static String uuidToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }

    @Named("stringToUuid")
    static UUID stringToUuid(String uuidString) {
        return uuidString == null ? null : UUID.fromString(uuidString);
    }
}