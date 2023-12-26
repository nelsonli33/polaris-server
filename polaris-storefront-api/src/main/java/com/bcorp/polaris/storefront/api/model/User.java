package com.bcorp.polaris.storefront.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User
{
    private Long id;
    private String name;
    private String title;
    private String uid;
    private String email;
    private String avatar;
    private String shortBio;
    private LocalDate birthday;
    private Integer isAuthor;
    private String websiteUrl;
    private String facebookUrl;
    private String linkedInUrl;
    private String youtubeUrl;

    @JsonCreator
    public User(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("title") String title,
            @JsonProperty("uid") String uid,
            @JsonProperty("email") String email,
            @JsonProperty("avatar") String avatar,
            @JsonProperty("short_bio") String shortBio,
            @JsonProperty("birthday") LocalDate birthday,
            @JsonProperty("is_author") Integer isAuthor,
            @JsonProperty("linkedin_url") String linkedInUrl,
            @JsonProperty("facebook_url") String facebookUrl,
            @JsonProperty("website_url") String websiteUrl,
            @JsonProperty("youtube_url") String youtubeUrl
    )
    {
        this.id = id;
        this.name = name;
        this.title = title;
        this.uid = uid;
        this.email = email;
        this.avatar = avatar;
        this.shortBio = shortBio;
        this.birthday = birthday;
        this.isAuthor = isAuthor;
        this.linkedInUrl = linkedInUrl;
        this.facebookUrl = facebookUrl;
        this.websiteUrl = websiteUrl;
        this.youtubeUrl = youtubeUrl;
    }
}
