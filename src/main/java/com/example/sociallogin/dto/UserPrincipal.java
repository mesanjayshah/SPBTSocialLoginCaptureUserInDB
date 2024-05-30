package com.example.sociallogin.dto;

import com.example.sociallogin.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Getter @Setter
public class UserPrincipal implements OAuth2User {

    private UUID id;
    private String email;
    private String name;
    private String picture;
    private Map<String, Object> attributes;

    public UserPrincipal(UUID id, String email, String name, String picture, Map<String, Object> attributes) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.picture = picture;
        this.attributes = attributes;
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getPicture(),
                attributes
        );
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAttribute(String name) {
        return (String) this.attributes.get(name);
    }

}

