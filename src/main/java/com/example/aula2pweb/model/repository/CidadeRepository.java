package com.example.aula2pweb.model.repository;

import com.example.aula2pweb.model.entity.endereco.Cidade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CidadeRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Cidade> cidadeList(){
        Query q = em.createQuery("from Cidade");
        return q.getResultList();
    }

    public void salvarCidade(Cidade cidade){
        em.persist(cidade);
    }

    public void atualizarCidade(Cidade cidade){
        em.merge(cidade);
    }

    public void removerCidade(Long id){
        Cidade c = em.find(Cidade.class, id);
        em.remove(c);
    }

    public Cidade cidade(Long id){
        return em.find(Cidade.class, id);
    }

}
