package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("UPDATE Country c set c.name=:name,c.code=:code where c.id=:id")
    @Modifying
    void updateCountryNameAndCode(String name,String code, Long id);

    @Query("select c.code from Country c where c.code=?1")
    String findByCode(String code);
}
