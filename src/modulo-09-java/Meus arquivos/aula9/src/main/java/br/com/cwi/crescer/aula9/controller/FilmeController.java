package br.com.cwi.crescer.aula9.controller;

import br.com.cwi.crescer.aula9.entity.Filme;
import br.com.cwi.crescer.aula9.service.ClassificacaoService;
import br.com.cwi.crescer.aula9.service.ElencoService;
import br.com.cwi.crescer.aula9.service.FilmeService;
import br.com.cwi.crescer.aula9.service.GeneroService;
import br.com.cwi.crescer.aula9.service.IdiomaService;
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
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    FilmeService filmeService;
    @Autowired
    GeneroService generoService;
    @Autowired
    ClassificacaoService classificacaoService;
    @Autowired
    IdiomaService idiomaService;
    @Autowired
    ElencoService elencoService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Filme filme = new Filme();
        if (id != null) {
            filme = filmeService.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("filme", filme);
        model.addAttribute("filmes", filmeService.findAll(pageable));
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("classificacoes", classificacaoService.findAll());
        model.addAttribute("idiomas", idiomaService.findAll());
        model.addAttribute("elencos", elencoService.findAll());
        return "filme";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Filme filme, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            filmeService.save(filme);
            return "redirect:filme";
        }
        return "filme";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Filme> filmes = filmeService.findAll(pageable);
        model.addAttribute("filmes", filmes);
        return "filme";
    }

}
