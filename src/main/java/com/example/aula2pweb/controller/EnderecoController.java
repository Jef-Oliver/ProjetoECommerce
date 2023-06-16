package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.entity.endereco.Endereco;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import com.example.aula2pweb.model.repository.CidadeRepository;
import com.example.aula2pweb.model.repository.EnderecoRepository;
import com.example.aula2pweb.model.repository.EstadoRepository;
import com.example.aula2pweb.model.repository.PessoasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Transactional
@Controller
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PessoasRepository pessoasRepository;


    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("enderecos", enderecoRepository.enderecoList());
        model.addAttribute("titulo", "Lista de Endereços");
        return new ModelAndView("/pessoa/pf/list", model);
    }

    @GetMapping("/form")
    public String form(Endereco endereco, ModelMap model) {
        modelCidadeEstado(model);
        return "/pessoa/pf/form";
    }


    @PostMapping("/save")
    public String save(Endereco endereco, RedirectAttributes ra) {
        enderecoRepository.salvarEndereco(endereco);
        ra.addFlashAttribute("mensagem", "Endereço cadastrado com sucesso!")
                .addFlashAttribute("class", "success");
        return "redirect:/pessoa/pf/list";
    }

    @GetMapping("/remove/{id}")
public ModelAndView remove(@PathVariable("id") Long id) {
        enderecoRepository.removerEndereco(id);
        return new ModelAndView("redirect:/pessoa/pf/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("endereco", enderecoRepository.endereco(id));
        return new ModelAndView("/pessoa/pf/form", model);
    }

    @GetMapping("/update")
    public ModelAndView update(Endereco endereco, RedirectAttributes ra) {
        enderecoRepository.atualizarEndereco(endereco);
        return new ModelAndView("redirect:/pessoa/pf/list");
    }

    private void modelCidadeEstado(ModelMap model) {
        model.addAttribute("cidades", cidadeRepository.cidadeList());
        model.addAttribute("estados", estadoRepository.estadoList());
    }
}
