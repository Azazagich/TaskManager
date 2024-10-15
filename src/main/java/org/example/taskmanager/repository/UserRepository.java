package org.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.taskmanager.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u left join u.tasks where u.id = :id")
//    Optional<User> findOne(@Param("id") Long id);
}
