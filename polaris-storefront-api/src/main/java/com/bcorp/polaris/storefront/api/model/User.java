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
    private String uid;
    private String email;
    private String avatar;
    private String shortBio;
    private String fullBio;
    private LocalDate birthday;
    private Integer isAuthor;
    private String twitter;
    private String github;
    private String linkedin;
    private String facebook;

    @JsonCreator
    public User(
            @JsonProperty("id") Long id,
            @JsonProperty("username") String name,
            @JsonProperty("uid") String uid,
            @JsonProperty("email") String email,
            @JsonProperty("avatar") String avatar,
            @JsonProperty("short_bio") String shortBio,
            @JsonProperty("full_bio") String fullBio,
            @JsonProperty("birthday") LocalDate birthday,
            @JsonProperty("is_author") Integer isAuthor,
            @JsonProperty("twitter") String twitter,
            @JsonProperty("github") String github,
            @JsonProperty("linkedin") String linkedin,
            @JsonProperty("facebook") String facebook)
    {
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.email = email;
        this.avatar = avatar;
        this.shortBio = shortBio;
        this.fullBio = fullBio;
        this.birthday = birthday;
        this.isAuthor = isAuthor;
        this.twitter = twitter;
        this.github = github;
        this.linkedin = linkedin;
        this.facebook = facebook;
    }
}
