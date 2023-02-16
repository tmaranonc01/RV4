package com.example.rv4.Pedido.Service;

import com.example.rv4.BaseService;
import com.example.rv4.Pedido.Domain.Pedido;
import com.example.rv4.Pedido.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService extends BaseService<Pedido, Long, PedidoRepository> {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido addPedido(Pedido nuevoPedido){
        return pedidoRepository.save(nuevoPedido);
    }

    public Pedido updatePedidoById(Pedido nuevoPedido){
        Optional<Pedido> pedido = null;
        pedido = pedidoRepository.findById(nuevoPedido.getId());
        if (pedido.isPresent()){
            pedidoRepository.save(nuevoPedido);
        }
        return pedido.get();
    }
}
