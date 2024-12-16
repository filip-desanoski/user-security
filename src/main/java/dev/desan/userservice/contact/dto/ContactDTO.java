package dev.desan.userservice.contact.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    private String firstName;
    private String lastName;
}
