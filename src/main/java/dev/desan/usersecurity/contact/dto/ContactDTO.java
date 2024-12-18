package dev.desan.usersecurity.contact.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    private String uuid;
    private String firstName;
    private String lastName;
}
