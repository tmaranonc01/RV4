package com.example.rv4.Pieza.Domain;

import com.example.rv4.Coche.Domain.Coche;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pieza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String nombre;
    private String descripcion;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "coche_id", referencedColumnName = "id")
    private Coche coche;

    @Nullable
    @Size(max = 255)
    private String foto;
}
