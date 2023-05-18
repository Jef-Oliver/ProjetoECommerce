package com.example.aula2pweb.model.entity.pessoas;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class PessoaFisica extends Pessoa {
    private String cpf;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
