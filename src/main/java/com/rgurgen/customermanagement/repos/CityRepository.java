package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c.code from City c where c.code=?1")
    String findByCode(String code);

    @Query("UPDATE City c set c.name=:name where c.id=:id")
    @Modifying
    @Transactional
    void updateName(Long id, String name);

    @Query("UPDATE City c set c.code=:code where c.id=:id")
    @Modifying
    @Transactional
    void updateCode(Long id, String code);

    @Query("UPDATE City c set c.country.id=:countryId where c.id=:id")
    @Modifying
    @Transactional
    void updateCountry(Long id, Long countryId);
}
