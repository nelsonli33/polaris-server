package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    private String name;
    private String title;
    private String uid;
    private String email;
    private String avatar;
    private String shortBio;
    private Byte isAuthor;
    private String websiteUrl;
    private String facebookUrl;
    private String linkedInUrl;
    private String youtubeUrl;
    private Byte isBlocked;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
