package br.com.cwi.crescer.aula9.controller;

import br.com.cwi.crescer.aula9.entity.Genero;
import br.com.cwi.crescer.aula9.service.GeneroService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Genero genero = new Genero();
        if (id != null) {
            genero = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("genero", genero);
        model.addAttribute("generos", service.findAll(pageable));
        return "genero";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Genero genero, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(genero);
            return "redirect:genero";
        }
        return "genero";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Genero> generos = service.findAll(pageable);
        model.addAttribute("generos", generos);
        return "genero";
    }

}
