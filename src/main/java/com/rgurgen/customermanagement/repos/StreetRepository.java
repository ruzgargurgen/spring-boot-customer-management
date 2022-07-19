package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    @Query("select s.code from Street s where s.code=:code")
    String findByCode(String code);

    @Query("update Street s set s.name=:name where s.id=:id")
    @Modifying
    @Transactional
    void updateStreetName(Long id, String name);

    @Query("update Street s set s.code=:code where s.id=:id")
    @Modifying
    @Transactional
    void updateStreetCode(Long id, String code);

    @Query("update Street s set s.district.id=:districtId where s.name=:id")
    @Modifying
    @Transactional
    void updateDistrict(Long id, Long districtId);
}
