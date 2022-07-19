package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query("select d.code from District d where d.code=:code")
    String findByCode(String code);

    @Query("update District d set d.name=:name where d.id=:id")
    @Modifying
    @Transactional
    void updateDistrictName(Long id, String name);

    @Query("update District d set d.code=:code where d.id=:id")
    @Modifying
    @Transactional
    void updateDistrictCode(Long id, String code);

    @Query("update District d set d.town.id=:townId where d.name=:id")
    @Modifying
    @Transactional
    void updateTown(Long id, Long townId);
}
