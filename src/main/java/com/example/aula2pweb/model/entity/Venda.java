package com.example.aula2pweb.model.entity;

import com.example.aula2pweb.controller.VendaController;
import com.example.aula2pweb.model.entity.endereco.Endereco;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Scope("session")
@Component
@Entity
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data = LocalDate.now();

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itensVendas = new ArrayList<ItemVenda>();

    @ManyToOne
    Pessoa pessoa;

    @OneToOne
    Endereco endereco;

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

    public List<ItemVenda> getItensVendas() {
        return itensVendas;
    }

    public void setItensVendas(List<ItemVenda> itensVendas) {
        this.itensVendas = itensVendas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", data=" + data +
                ", itensVendas=" + itensVendas +
                ", pessoa=" + pessoa +
                ", endereco=" + endereco +
                '}';
    }
}
