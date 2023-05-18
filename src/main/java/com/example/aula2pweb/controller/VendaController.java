package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.entity.ItemVenda;
import com.example.aula2pweb.model.entity.Produto;
import com.example.aula2pweb.model.entity.Venda;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import com.example.aula2pweb.model.repository.PessoaRepository;
import com.example.aula2pweb.model.repository.ProdutosRepository;
import com.example.aula2pweb.model.repository.VendaRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    Venda venda;

    @Autowired
    PessoaRepository pessoaRepository;


    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("vendas", vendaRepository.buscarVendas());
        return new ModelAndView("venda/listavendas", model);
    }
    @GetMapping("/listavendas")
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("vendas", vendaRepository.buscarVendas());
        return new ModelAndView("venda/listavendas", model);
    }

    //mapeamento para a tela inicial
    @GetMapping("/index")
    public String index() {
        return "produto/index";
    }

    @PostMapping("/add")
    public String add(ItemVenda itemVenda) {
        Produto produto = produtosRepository.produto(itemVenda.getProduto().getId());
        itemVenda.setProduto(produto);
        venda.getItensVendas().add(itemVenda);
        itemVenda.setVenda(venda);
        return "redirect:/produtos/list";
    }
    //delete
    @GetMapping("/remove/{iterStat}")
    public ModelAndView remove(@PathVariable("iterStat") int id) {
        venda.getItensVendas().remove(id);
        return new ModelAndView("redirect:/vendas/carr");
    }
    //View do carrinho
    @GetMapping("/carr")
    public String carrinho(Venda venda, ModelMap model) {
        model.addAttribute("Titulo: ","itens adicionados");
        return "carrinho/carr";

    }

    @GetMapping("/finalizar")
    public String finalizar(HttpSession session) {
        venda.setPessoa(pessoaRepository.pessoa(1L));
        vendaRepository.save(venda);
        venda.getItensVendas().clear();
        session.invalidate();
        return "redirect:/vendas/listavendas";
    }
    //detalhes da venda
    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", vendaRepository.list(id));
        return new ModelAndView("venda/detalhes", model);
    }
}



    

