package dev.desan.usersecurity.contact.mapper;

import dev.desan.usersecurity.contact.dto.ContactDTO;
import dev.desan.usersecurity.contact.model.Contact;
import dev.desan.usersecurity.infrastructure.mapper.GeneralMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ContactMapper extends GeneralMapper<ContactDTO, Contact> {

    @Mapping(target = "uuid", source = "uuid", qualifiedByName = "uuidToString")
    ContactDTO entityToDto(Contact entity);

    @Mapping(target = "uuid", source = "uuid", qualifiedByName = "stringToUuid")
    Contact dtoToEntity(ContactDTO dto);

    @Named("uuidToString")
    static String uuidToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }

    @Named("stringToUuid")
    static UUID stringToUuid(String uuidString) {
        return uuidString == null ? null : UUID.fromString(uuidString);
    }
}
