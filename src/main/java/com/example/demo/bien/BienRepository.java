package com.example.demo.bien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BienRepository
        extends JpaRepository<Bien, Long> {
    @Query("SELECT s FROM Bien s WHERE s.name = ?1")
    Optional<Bien> findBienByName(String name);
}
