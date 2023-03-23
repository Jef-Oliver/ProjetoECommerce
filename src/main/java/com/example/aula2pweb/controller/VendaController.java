package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.repository.ProdutosRepository;
import com.example.aula2pweb.model.repository.VendaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {
    @PersistenceContext
    private EntityManager vd;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("vendas", vendaRepository.buscarVendas());
        return new ModelAndView("venda/list", model);
    }

    @GetMapping("/index")
    public String index(){
        return "produto/index";
    }

}

