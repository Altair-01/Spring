package com.example.demo.Bien;

import com.example.demo.Bien.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BienRepository
        extends JpaRepository<Bien, Long> {
    @Query("SELECT s FROM Bien s WHERE s.title = ?1")
    Optional<Bien> findBienByTitle(String title);
    @Query("SELECT s FROM Bien s WHERE s.id=?1")
    Optional<Bien> findBienById(Long id);
}
