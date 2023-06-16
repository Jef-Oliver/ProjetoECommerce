package com.example.aula2pweb.model.entity.endereco;

import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String tipoEndereco;
    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;

    @OneToOne
    public Cidade cidade;

    @ManyToOne
    public Pessoa pessoa;

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return  sb.append("tipoEndereco: ").append(tipoEndereco).append("\n")
                .append(", cep: ").append(cep).append("\n")
                .append(", logradouro: ").append(logradouro).append("\n")
                .append(", complemento: ").append(complemento).append("\n")
                .append(", bairro: ").append(bairro).append("\n")
                .append(", cidade: ").append(cidade.toString())
                .toString();

    }
}
