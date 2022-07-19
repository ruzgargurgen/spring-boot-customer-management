package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT u FROM Customer u WHERE u.firstname = :firstname")
    Optional<Customer> findByFirstName(@Param("firstname") String firstname);

    Optional<Customer> findByEmail(String email);
}
