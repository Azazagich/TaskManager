package org.example.taskmanager.repository;

import org.example.taskmanager.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> { }
