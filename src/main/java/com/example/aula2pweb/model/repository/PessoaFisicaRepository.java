package com.example.aula2pweb.model.repository;

import java.util.List;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import com.example.aula2pweb.model.entity.pessoas.PessoaFisica;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PessoaFisicaRepository
{
    @PersistenceContext
    private EntityManager em;

    public void savePF(PessoaFisica pessoaFisica)
    {
        em.persist(pessoaFisica);
    }

    public PessoaFisica pessoaFisica(Long id){
        return em.find(PessoaFisica.class, id);
    }

    public void removePF(Long id)
    {
        PessoaFisica p = em.find(PessoaFisica.class, id);
        em.remove(p);
    }

    public void updatePF(PessoaFisica pessoaFisica)	{
        em.merge(pessoaFisica);
    }

    public List<Pessoa> pessoaListCpf()
    {
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }
}