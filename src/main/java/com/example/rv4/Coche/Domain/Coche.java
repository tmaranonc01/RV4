package com.example.rv4.Coche.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.example.rv4.Pieza.Domain.Pieza;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String Modelo;
    @NotNull
    private String Motor;
    private int ano;

    @JsonIgnore
    @OneToMany(mappedBy = "coche", fetch = FetchType.LAZY)
    private List<Pieza> piezas;
}
