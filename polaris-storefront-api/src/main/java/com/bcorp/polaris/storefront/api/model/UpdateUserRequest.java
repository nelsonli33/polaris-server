package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserRequest
{
    private String name;
    private String title;
    private String shortBio;
    private String websiteUrl;
    private String facebookUrl;
    private String linkedInUrl;
    private String youtubeUrl;

    public UpdateUserRequest(
            @JsonProperty("name") String name,
            @JsonProperty("title") String title,
            @JsonProperty("short_bio") String shortBio,
            @JsonProperty("website_url") String websiteUrl,
            @JsonProperty("facebook_url") String facebookUrl,
            @JsonProperty("linkedin_url") String linkedInUrl,
            @JsonProperty("youtube_url") String youtubeUrl)
    {
        this.name = name;
        this.title = title;
        this.shortBio = shortBio;
        this.websiteUrl = websiteUrl;
        this.facebookUrl = facebookUrl;
        this.linkedInUrl = linkedInUrl;
        this.youtubeUrl = youtubeUrl;
    }
}
