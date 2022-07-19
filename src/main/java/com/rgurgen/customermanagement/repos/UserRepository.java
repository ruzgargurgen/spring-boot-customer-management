package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.Role;
import com.rgurgen.customermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    @Query(value = "select u from User u where u.username = :username")
    Optional<User> findByUserName(@Param("username") String username);

    @Modifying
    @Query(value = "update User u set u.role = :role where u.username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
