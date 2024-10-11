package org.example.taskmanager.repository;

import org.example.taskmanager.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends RoleRepositoryWithBagRelationship, JpaRepository<Role, Long> {

    default Optional<Role> findOne(@Param("id") Long id){
        return findOneRole(id);
    }

//    @Query("select r from Role r join fetch r.users where r.id = :id")
//    Optional<Role> findOneJPQL(@Param("id") Long id);
}
