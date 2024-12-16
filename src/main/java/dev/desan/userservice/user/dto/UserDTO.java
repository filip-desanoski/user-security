package dev.desan.userservice.user.dto;

import dev.desan.userservice.contact.dto.ContactDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class UserDTO {
    private UUID uuid;
    private String username;
    private ContactDTO contact;
    private Set<String> roles;
}
