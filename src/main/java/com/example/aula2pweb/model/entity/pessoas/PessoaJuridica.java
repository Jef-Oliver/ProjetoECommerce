package com.example.aula2pweb.model.entity.pessoas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.stereotype.Component;

@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}