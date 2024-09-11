package org.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.taskmanager.domain.User;


public interface UserRepository extends JpaRepository<User, Long>{ }
