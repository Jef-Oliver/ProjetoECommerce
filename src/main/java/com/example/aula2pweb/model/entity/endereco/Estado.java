package com.example.aula2pweb.model.entity.endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Estado {

    @Id
    private Long id;

    public String nome;
    public String sigla;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Estado")
                .append("nome='").append(nome).append('\'')
                .append(", sigla='").append(sigla).append('\'')
                .append(", id=").append(id).toString();
    }
}
