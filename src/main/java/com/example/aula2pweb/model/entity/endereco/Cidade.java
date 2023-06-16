package com.example.aula2pweb.model.entity.endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Cidade {
    public String nome;

    @OneToOne
    public Estado estado;

    @Id
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb
                .append(nome)
                .append(", Estado: ").append(estado.getSigla())
                .toString();
    }
}
