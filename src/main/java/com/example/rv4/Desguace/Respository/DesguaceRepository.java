package com.example.rv4.Desguace.Respository;

import com.example.rv4.Coche.Domain.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesguaceRepository extends JpaRepository<Coche, Long> {
}
