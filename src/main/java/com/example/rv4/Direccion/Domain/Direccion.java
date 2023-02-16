package com.example.rv4.Direccion.Domain;


import javax.persistence.*;

import com.example.rv4.Usuario.Domain.Usuario;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String calle;
    private int portal;
    private String poblacion;

    @OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Usuario usuario;
}
