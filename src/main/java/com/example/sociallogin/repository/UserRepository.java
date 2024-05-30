package com.example.sociallogin.repository;

import com.example.sociallogin.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findByUsername(String username);
}
