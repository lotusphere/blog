package com.lotusphere.blog.repository;

import com.lotusphere.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
