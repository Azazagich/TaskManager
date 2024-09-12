package org.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.taskmanager.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{ }
