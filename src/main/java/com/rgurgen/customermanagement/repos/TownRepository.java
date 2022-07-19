package com.rgurgen.customermanagement.repos;

import com.rgurgen.customermanagement.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    @Query("select t.code from Town t where t.code=:code")
    String findByCode(String code);

    @Query("UPDATE Town t set t.name=:name where t.id=:id")
    @Modifying
    @Transactional
    void updateName(Long id, String name);

    @Query("UPDATE Town t set t.code=:code where t.id=:id")
    @Modifying
    @Transactional
    void updateCode(Long id, String code);

    @Query("UPDATE Town t set t.city.id=:cityId where t.id=:id")
    @Modifying
    @Transactional
    void updateCity(Long id, Long cityId);
}
