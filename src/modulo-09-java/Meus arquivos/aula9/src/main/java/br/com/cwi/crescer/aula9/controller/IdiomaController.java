package br.com.cwi.crescer.aula9.controller;

import br.com.cwi.crescer.aula9.entity.Idioma;
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
@RequestMapping("/idioma")
public class IdiomaController {

    @Autowired
    IdiomaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Idioma idioma = new Idioma();
        if (id != null) {
            idioma = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("idioma", idioma);
        model.addAttribute("idiomas", service.findAll(pageable));
        return "idioma";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Idioma idioma, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(idioma);
            return "redirect:idioma";
        }
        return "idioma";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Idioma> idiomas = service.findAll(pageable);
        model.addAttribute("idiomas", idiomas);
        return "idioma";
    }

}
