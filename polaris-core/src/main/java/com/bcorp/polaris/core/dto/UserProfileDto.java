package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto
{
    private String name;
    private String title;
    private String avatar;
    private String shortBio;
    private String websiteUrl;
    private String facebookUrl;
    private String linkedInUrl;
    private String youtubeUrl;
}
