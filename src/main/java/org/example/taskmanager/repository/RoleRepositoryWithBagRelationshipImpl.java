package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.taskmanager.domain.Role;
import org.example.taskmanager.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collector;

//@Repository
//public class RoleRepositoryWithBagRelationshipImpl implements RoleRepositoryWithBagRelationship {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Optional<Role> findOneRole(Long id) {
//        final String QUERY = "select role from Role role where role.id = :id";
//        Role role = entityManager.createQuery(QUERY, Role.class)
//                .setParameter("id", id)
//                .getSingleResult();
//        if (role.getUsers().isEmpty()) {
//            role.setUsers(findRoleUsers(role));
//        }
//
//        return Optional.of(role);
//    }
//
//    public Set<User> findRoleUsers(Role role){
//        final String QUERY = "select u from User u join fetch u.role where u.role = :role";
//        return new HashSet<>(entityManager
//                .createQuery(QUERY, User.class)
//                .setParameter("role", role)
//                .getResultList());
//    }
//}
