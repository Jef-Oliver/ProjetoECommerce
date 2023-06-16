package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.entity.ItemVenda;
import com.example.aula2pweb.model.entity.Produto;
import com.example.aula2pweb.model.entity.Venda;
import com.example.aula2pweb.model.entity.endereco.Endereco;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import com.example.aula2pweb.model.repository.*;
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
    PessoasRepository pessoaRepository;

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    Venda venda;

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("vendas", vendaRepository.buscarVendas());
        model.addAttribute("titulo", "Lista de Vendas");
        return new ModelAndView("venda/listavendas", model);
    }

    //    @GetMapping("/list")
//    public ModelAndView listar(ModelMap model){
//
//        model.addAttribute("vendas", vendasRepository.vendaList());
//
//        return new ModelAndView("/venda/list", model);
//    }
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

    //save
    @GetMapping("/finalizar")
    public String finalizar(HttpSession session) {
        venda.setId(null);
        vendaRepository.save(venda);
        venda.getItensVendas().clear();
        session.invalidate();
        return "redirect:/vendas/listavendas";
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
        model.addAttribute("titulo: ", "itens adicionados");
        modelAddPessoas(model);
        return "carrinho/carr";
    }
    //detalhes da venda
    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", vendaRepository.list(id));
        model.addAttribute("titulo", "Venda detalhada");
        return new ModelAndView("venda/detalhes", model);
    }

    @GetMapping("/cart/{id}")
    public String endereco(@PathVariable("id") Long id, ModelMap model) {

        Pessoa p = pessoaRepository.pessoa(id);
        venda.setPessoa(p);
        modelAddPessoas(model);
        return "/carrinho/carr";
    }

    @GetMapping("/entregar/{id}")
    public String entrega(@PathVariable Long id, ModelMap model) {
        Endereco e = enderecoRepository.endereco(id);
        venda.setEndereco(e);
        modelAddPessoas(model);
        return "/carrinho/carr";
    }

    private void modelAddPessoas(ModelMap modelMap) {
        modelMap.addAttribute("pessoas", pessoaRepository.pessoas());
    }
}