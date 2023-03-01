package com.github.GuilhermePonce.Medilab.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Telefone {
    @Id
    @SequenceGenerator(
            name = "telefone_sequence",
            sequenceName = "telefone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "telefone_sequence"
    )
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "CodigoCliente")
    private Cliente cliente;

    private String telefone;
    @ManyToOne
    private TipoTelefone tipoTelefone;

    private boolean active = true;

    public Telefone(Long codigo, Cliente cliente, String telefone, TipoTelefone tipoTelefone, boolean active) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.active = active;
    }

    public Telefone() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", telefone='" + telefone + '\'' +
                ", tipoTelefone=" + tipoTelefone +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(codigo, telefone.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
