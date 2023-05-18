package com.example.aula2pweb.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String descricao;
    private double valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}