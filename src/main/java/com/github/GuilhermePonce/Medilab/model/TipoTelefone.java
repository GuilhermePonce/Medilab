package com.github.GuilhermePonce.Medilab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class TipoTelefone {
    @Id
    @SequenceGenerator(
            name = "tipo_telefone_sequence",
            sequenceName = "tipo_telefone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tipo_telefone_sequence"
    )
    private Long codigo;
    private String tipoTelefone;

    public TipoTelefone(Long codigo, String tipoTelefone) {
        this.codigo = codigo;
        this.tipoTelefone = tipoTelefone;
    }

    public TipoTelefone() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public String toString() {
        return "TipoTelefone{" +
                "codigo=" + codigo +
                ", tipoTelefone='" + tipoTelefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTelefone that = (TipoTelefone) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
