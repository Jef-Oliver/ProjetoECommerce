package com.example.aula2pweb.model.repository;

import com.example.aula2pweb.model.entity.endereco.Endereco;
import com.example.aula2pweb.model.entity.endereco.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstadoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Estado> estadoList(){
        Query q = em.createQuery("from Estado");
        return q.getResultList();
    }

    public void salvarEstado(Estado estado){
        em.persist(estado);
    }

    public void atualizarEstado(Estado estado){
        em.merge(estado);
    }

    public void removerEstado(Long id){
        Estado e = em.find(Estado.class, id);
        em.remove(e);
    }

    public Estado estado(Long id){
        return em.find(Estado.class, id);
    }
}
