package com.bcorp.polaris.storefront.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    private String name;
    private String email;
    private String password;
    private String shortBio;
    private String fullBio;
}
