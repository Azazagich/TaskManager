package org.example.taskmanager.repository;

import jakarta.persistence.PreRemove;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE Task task SET task.createBy = null WHERE task.createBy.id = :id")
//    void updateToNullTasksByCreateById(@Param("id") Long id);
//
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Task tasks SET tasks.performers = null WHERE :user MEMBER OF tasks.performers")
//    void updateToNullTasksPerformers(@Param("user") User user);

    @Modifying
    @Transactional
    @Query("UPDATE Task task SET task.createBy.id = null where task.createBy.id = :id")
    void updateToNullCreateBy(@Param("id") Long UserId);
}
