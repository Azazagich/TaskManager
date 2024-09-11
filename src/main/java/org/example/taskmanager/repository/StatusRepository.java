package org.example.taskmanager.repository;

import org.example.taskmanager.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> { }
