package com.example.sociallogin.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Oauth2UserInfoDto {

    private String id;

    private String name;

    @Column(unique = true)
    private String email;

    private String picture;
}
