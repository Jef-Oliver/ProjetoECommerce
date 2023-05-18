package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    ProdutosRepository repository;

    @GetMapping("/index")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView("produto/index", model);//Aqui ele está passando para a view list todos
        //os produtos do banco de dados
    }
}
