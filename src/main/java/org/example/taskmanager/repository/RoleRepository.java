package org.example.taskmanager.repository;

import org.example.taskmanager.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> { }
