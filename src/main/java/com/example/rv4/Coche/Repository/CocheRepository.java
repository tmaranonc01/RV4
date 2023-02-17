package com.example.rv4.Coche.Repository;

import com.example.rv4.Coche.Domain.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CocheRepository extends JpaRepository<Coche, Long> {
}
