package com.bcorp.polaris.storefront.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class RegisterUserRequest
{
    @NotBlank(message = "名稱 必填")
    private String name;
    @NotBlank(message = "E-mail 必填")
    @Email(message = "E-mail 格式不正確")
    private String email;
    @NotBlank(message = "密碼 必填")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "密碼須至少 6 位字且包含英文字母及數字")
    private String password;

    @JsonCreator
    public RegisterUserRequest(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
