package com.example.rv4.Direccion.Repository;

import com.example.rv4.Direccion.Domain.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
