package com.example.aula2pweb.model.repository;

import java.util.List;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PessoasRepository
{
    @PersistenceContext
    private EntityManager em;
    public List<Pessoa> pessoas()	{
        Query query = em.createQuery("from Pessoa");
        return query.getResultList();
    }

    public Pessoa pessoa(Long id){
        return em.find(Pessoa.class, id);
    }
}
