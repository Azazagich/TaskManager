package org.example.taskmanager.repository;

import org.example.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.taskmanager.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u left join u.tasks where u.id = :id")
//    Optional<User> findOne(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User users SET users.role.id = null where users.role.id = :id ")
    void updateToNullUsers(@Param("id") Long roleId);

    @Modifying
    @Transactional
    @Query("UPDATE User users SET users.tasks = null WHERE :task MEMBER OF users.tasks")
    void updateToNullPerformersInTasks(@Param("task") Task task);

//    @Modifying
//    @Transactional
//    @Query("UPDATE User users SET users.tasks.id = null where users.role.id = :id ")
//    void updateToNullUsers(@Param("id") Long roleId);
}
