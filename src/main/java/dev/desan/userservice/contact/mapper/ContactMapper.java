package dev.desan.userservice.contact.mapper;

import dev.desan.userservice.contact.dto.ContactDTO;
import dev.desan.userservice.contact.model.Contact;
import dev.desan.userservice.infrastructure.mapper.GeneralMapper;
import org.springframework.web.bind.annotation.Mapping;

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
