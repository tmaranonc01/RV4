package com.example.rv4.Pedido.Controller;

import com.example.rv4.Pedido.Domain.Pedido;
import com.example.rv4.Pedido.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listaPedidos(){
        List<Pedido> pedidos = pedidoService.getPedido();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> PedidoPorId(@PathVariable Long id){
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedido){
        pedido.setTotal(pedido.getTotal());
        pedido.setOrigen(pedido.getOrigen());
        pedido.setDestino(pedido.getDestino());
        pedido.setDesguaces(pedido.getDesguaces());
        Pedido pedido1 = pedidoService.addPedido(pedido);
        return new ResponseEntity<>(pedido1, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Pedido> modifyPedido(@RequestBody Pedido nuevoPedido){
        Pedido pedido = pedidoService.updatePedidoById(nuevoPedido);
        return new ResponseEntity<>(pedido,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
