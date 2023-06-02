package com.example.aula2pweb.model.entity.endereco;

public class CepRecebido {
    String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "CepRecebido{" +
                "cep='" + cep + '\'' +
                '}';
    }
}
