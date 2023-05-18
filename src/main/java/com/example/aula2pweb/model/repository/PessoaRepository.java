package com.example.aula2pweb.model.repository;

import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {

    @PersistenceContext
    private EntityManager em;
    public Pessoa pessoa(Long id)
    {
        return em.find(Pessoa.class, id);
    }


}
