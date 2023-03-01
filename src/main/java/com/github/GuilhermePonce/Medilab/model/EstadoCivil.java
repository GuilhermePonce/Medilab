package com.github.GuilhermePonce.Medilab.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class EstadoCivil {
    @Id
    @SequenceGenerator(
            name = "estado_civil_sequence",
            sequenceName = "estado_civil_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "estado_civil_sequence"
    )
    private Long codigo;
    private String estadoCivil;

    public EstadoCivil(Long codigo, String estadoCivil) {
        this.codigo = codigo;
        this.estadoCivil = estadoCivil;
    }

    public EstadoCivil() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "EstadoCivil{" +
                "codigo=" + codigo +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoCivil that = (EstadoCivil) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
