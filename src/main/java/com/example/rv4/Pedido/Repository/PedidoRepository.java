package com.example.rv4.Pedido.Repository;

import com.example.rv4.Pedido.Domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
