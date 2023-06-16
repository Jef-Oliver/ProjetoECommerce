package com.example.aula2pweb.controller;


import com.example.aula2pweb.model.entity.pessoas.PessoaJuridica;
import com.example.aula2pweb.model.repository.PessoaJuridicaRepository;
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
@RequestMapping("pj")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    PessoasRepository pessoaRepository;

    @GetMapping("/list")
    public ModelAndView listarCnpj(ModelMap model)
    {
        model.addAttribute("juridicas", pessoaJuridicaRepository.pessoaListCnpj());
        model.addAttribute("titulo", "Lista de Pessoas Jurídicas");
        return new ModelAndView("/pessoa/pj/list", model);
    }

    @GetMapping("/form")
    public String form(PessoaJuridica pessoaJuridica)
    {
        return "/pessoa/pj/form";
    }

    @PostMapping("/save")
    public String save(PessoaJuridica pessoaJuridica, RedirectAttributes ra)
    {
        pessoaJuridicaRepository.savePJ(pessoaJuridica);
        ra.addFlashAttribute("mensagem", "Pessoa cadastrada com sucesso!")
                .addFlashAttribute("class", "success");
        return "redirect:/pj/list";
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id)
    {
        pessoaJuridicaRepository.removePJ(id);
        return new ModelAndView("redirect:/pj/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model)
    {
        model.addAttribute("pessoaJuridica", pessoaJuridicaRepository.pessoaJuridica(id));
        return new ModelAndView("/pessoa/pj/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica)
    {
        pessoaJuridicaRepository.updatePJ(pessoaJuridica);
        return new ModelAndView("redirect:/pj/list");
    }
}

