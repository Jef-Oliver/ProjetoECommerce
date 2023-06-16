package com.example.aula2pweb.model.repository;
import com.example.aula2pweb.model.entity.endereco.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnderecoRepository {

    @PersistenceContext
    private EntityManager em;

        public List<Endereco> enderecoList(){
            Query q = em.createQuery("from Endereco");
            return q.getResultList();
        }

    public void salvarEndereco(Endereco endereco){
        em.persist(endereco);
    }

    public void atualizarEndereco(Endereco endereco){
        em.merge(endereco);
    }

    public void removerEndereco(Long id){
        Endereco e = em.find(Endereco.class, id);
        em.remove(e);
    }

    public Endereco endereco(Long id){
        return em.find(Endereco.class, id);
    }
}
