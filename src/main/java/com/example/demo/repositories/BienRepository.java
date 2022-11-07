package com.example.demo.repositories;

import com.example.demo.entities.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "rest")

public interface BienRepository
        extends JpaRepository<Bien, Long> {
    @Query("SELECT s FROM Bien s WHERE s.title = ?1")
    Optional<Bien> getBienByTitle(String title);
    @Query("SELECT s FROM Bien s WHERE s.id=?1")
    Optional<Bien> findBienById(Long id);
}
