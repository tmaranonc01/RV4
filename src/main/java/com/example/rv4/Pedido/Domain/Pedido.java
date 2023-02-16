package com.example.rv4.Pedido.Domain;

import javax.persistence.*;

import com.example.rv4.Desguace.Domain.Desguace;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double total;
    private String origen;
    private String destino;

    @ManyToMany(mappedBy = "pedidos")
    private List<Desguace> desguaces;
}
