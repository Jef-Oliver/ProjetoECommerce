package com.example.aula2pweb.model.repository;

import com.example.aula2pweb.model.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//faz operacoes no banco de dados
@Repository
public class ProdutosRepository {
    @PersistenceContext
    private EntityManager em; //responsável por gerenciar entidades, persistir, pesquisar e excluir objetos do bd

    public void save(Produto produto) {
        em.persist(produto);
    }

    public Produto list(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarProdutos() {
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(Long id) {
        Produto p = em.find(Produto.class, id);
        em.remove(p);
    }

    public void update(Produto produto) {
        em.merge(produto);
    }


}
