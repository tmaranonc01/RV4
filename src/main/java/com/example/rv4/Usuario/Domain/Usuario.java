package com.example.rv4.Usuario.Domain;

import javax.persistence.*;

import com.example.rv4.Direccion.Domain.Direccion;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String DNI;
    private String correo;
    private String nombreUsuario;
    private String contrasena;

    @OneToOne(optional = false)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = true)
    private Direccion direccion;

}

