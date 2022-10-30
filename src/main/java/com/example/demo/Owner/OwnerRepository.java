package com.example.demo.Owner;

import com.example.demo.Bien.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository
extends JpaRepository<Owner, Long> {

    @Query("SELECT s FROM Bien s WHERE s.name = ?1")
    Optional<Owner> findBienByName(String name);

    @Query("SELECT s.biens FROM Owner s WHERE s.id = ?1")
    List<Bien> getBiensByOwner(Long id);
}
