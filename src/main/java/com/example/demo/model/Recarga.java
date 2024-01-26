package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Recarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "operador_id", nullable = false)
    private Operador operador;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;

    public BigDecimal getValor() {
        return this.valor;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public Operador getOperador() {
        return this.operador;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public void setOperador(Operador operador) {
        this.operador = operador;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}