package com.example.aula2pweb.model.repository;

import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import com.example.aula2pweb.model.entity.pessoas.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaJuridicaRepository
{
    @PersistenceContext
    private EntityManager em;

    public void savePJ(PessoaJuridica pessoaJuridica)
    {
        em.persist(pessoaJuridica);
    }

    public PessoaJuridica pessoaJuridica(Long id)
    {
        return em.find(PessoaJuridica.class, id);
    }

    public void removePJ(Long id)
    {
        PessoaJuridica p = em.find(PessoaJuridica.class, id);
        em.remove(p);
    }

    public void updatePJ(PessoaJuridica pessoaJuridica)
    {
        em.merge(pessoaJuridica);
    }

    public List<Pessoa> pessoaListCnpj()
    {
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }
}
