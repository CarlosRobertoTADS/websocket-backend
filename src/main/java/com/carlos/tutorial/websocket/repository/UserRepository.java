package com.carlos.tutorial.websocket.repository;

import com.carlos.tutorial.websocket.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {
}
