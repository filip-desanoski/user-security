package dev.desan.usersecurity.user.dto;

import dev.desan.usersecurity.contact.dto.ContactDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDTO {
    private String uuid;
    private String username;
    private ContactDTO contact;
    private Set<String> roles;
}
