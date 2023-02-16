package com.example.rv4.Desguace.Domain;

import javax.persistence.*;

import com.example.rv4.Pedido.Domain.Pedido;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Desguace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String direccion;
    private String nombre;
    private String ciudad;
    private String tlf;

    @ManyToMany
    @JoinTable(
            name = "desguaces_pedidos",
            joinColumns = @JoinColumn(name = "desguace_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id",
                    referencedColumnName = "id")
    )
    private List<Pedido> pedidos;
}
