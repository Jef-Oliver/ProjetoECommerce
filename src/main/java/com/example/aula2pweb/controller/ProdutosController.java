package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.entity.Produto;
import com.example.aula2pweb.model.repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {
    @Autowired
    ProdutosRepository repository;

    //mapeamento para a tela inicial
    @GetMapping("/index")
    public String index(){
        return "produto/index";
    }

    @GetMapping("/form")
    public String form(Produto produto){
        return "produto/form";
    }
    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView ("produto/list", model);//Aqui ele está passando para a view list todos
        //os produtos do banco de dados
    }
    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        repository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.produto(id));
        return new ModelAndView("/produto/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
}
