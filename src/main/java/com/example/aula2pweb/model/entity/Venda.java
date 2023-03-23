package com.example.aula2pweb.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data = LocalDate.now();

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itensVendas = new ArrayList<ItemVenda>();

    public double totalVendas(){
        double total = 0;
        for(ItemVenda item : itensVendas){
            total = total + item.total();
        }
        return total;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public List<ItemVenda> getItens() {
        return itensVendas;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itensVendas = itens;
    }
}
