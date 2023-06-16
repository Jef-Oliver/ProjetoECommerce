package com.example.aula2pweb.controller;

import com.example.aula2pweb.model.entity.endereco.Cidade;
import com.example.aula2pweb.model.entity.endereco.Endereco;
import com.example.aula2pweb.model.entity.endereco.Estado;
import com.example.aula2pweb.model.entity.pessoas.Pessoa;
import com.example.aula2pweb.model.entity.pessoas.PessoaFisica;
import com.example.aula2pweb.model.repository.CidadeRepository;
import com.example.aula2pweb.model.repository.EstadoRepository;
import com.example.aula2pweb.model.repository.PessoaFisicaRepository;
import com.example.aula2pweb.model.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Transactional
@Controller
@RequestMapping("pf")
public class PessoaFisicaController {
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;


    @GetMapping("/list")
    public ModelAndView listarCpf(ModelMap model) {
        model.addAttribute("fisicas", pessoaFisicaRepository.pessoaListCpf());
        model.addAttribute("titulo", "Lista de Pessoas Físicas");
        return new ModelAndView("/pessoa/pf/list", model);
    }

//    @GetMapping("/form")
//    public String form(PessoaFisica pessoaFisica, ModelMap model) {
//        model.addAttribute("pessoaFisica", pessoaFisica);
//        // inserindo a lista de cidades e estados no model
//        model.addAttribute("cidade", cidadeRepository.cidadeList());
//        model.addAttribute("estado", estadoRepository.estadoList());
//        return "/pessoa/pf/form";
//    }
        @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica, ModelMap model)
    {
        modelCidadeEstado(model);
        model.addAttribute("pessoafisica", new PessoaFisica());
        return "/pessoa/pf/form";
    }

    @PostMapping("/save")
    public String save(PessoaFisica pessoaFisica, BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return form(pessoaFisica, model);
//        }

        pessoaFisica.getEnderecos().get(0).setPessoa(pessoaFisica);
        pessoaFisicaRepository.savePF(pessoaFisica);
        return "redirect:/pf/list";
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        pessoaFisicaRepository.removePF(id);
        return new ModelAndView("redirect:/pf/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaFisica", pessoaFisicaRepository.pessoaFisica(id));
        return new ModelAndView("/pessoa/pf/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        pessoaFisicaRepository.updatePF(pessoaFisica);
        return new ModelAndView("redirect:/pf/list");
    }

    private void modelCidadeEstado(ModelMap model)
    {
        model.addAttribute("cidades", cidadeRepository.cidadeList());
        model.addAttribute("estados", estadoRepository.estadoList());
    }
}
