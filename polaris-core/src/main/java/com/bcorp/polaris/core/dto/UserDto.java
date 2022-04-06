package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    private String name;
    private String uid;
    private String email;
    private String avatar;
    private String shortBio;
    private String fullBio;
    private LocalDate birthday;
    private Byte isAuthor;
    private String twitter;
    private String github;
    private String linkedin;
    private String facebook;
    private Byte isBlocked;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
