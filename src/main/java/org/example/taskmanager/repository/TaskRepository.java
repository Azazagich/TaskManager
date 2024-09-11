package org.example.taskmanager.repository;

import org.example.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> { }