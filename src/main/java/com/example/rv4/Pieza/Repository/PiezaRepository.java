package com.example.rv4.Pieza.Repository;

import com.example.rv4.Pieza.Domain.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiezaRepository extends JpaRepository<Pieza, Long> {
}
