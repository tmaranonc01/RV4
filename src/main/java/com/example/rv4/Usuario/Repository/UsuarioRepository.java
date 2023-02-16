package com.example.rv4.Usuario.Repository;

import com.example.rv4.Usuario.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
