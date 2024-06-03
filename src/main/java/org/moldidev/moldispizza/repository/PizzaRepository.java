package org.moldidev.moldispizza.repository;

import org.moldidev.moldispizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
    Optional<Pizza> findByName(String name);
}
