package com.github.GuilhermePonce.Medilab.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class TipoDocumento {
    @Id
    @SequenceGenerator(
            name = "tipo_documento_sequence",
            sequenceName = "tipo_documento_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tipo_documento_sequence"
    )
    private Long codigo;
    private String tipoDocumento;
    private String sigla;

    public TipoDocumento(Long codigo, String tipoDocumento, String sigla) {
        this.codigo = codigo;
        this.tipoDocumento = tipoDocumento;
        this.sigla = sigla;
    }

    public TipoDocumento() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" +
                "codigo=" + codigo +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDocumento that = (TipoDocumento) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
