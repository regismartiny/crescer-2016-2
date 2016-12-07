package br.com.cwi.crescer.aula9.controller;

import br.com.cwi.crescer.aula9.entity.Usuario;
import br.com.cwi.crescer.aula9.service.UsuarioService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Usuario usuario = new Usuario();
        if (id != null) {
            usuario = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios", service.findAll(pageable));
        return "usuario";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            String senhaCripto = new BCryptPasswordEncoder().encode(usuario.getSenha());
            Usuario user = new Usuario(usuario.getNome(), usuario.getEmail(), senhaCripto);
            service.save(user);
            return "redirect:usuario";
        }
        return "usuario";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Usuario> usuarios = service.findAll(pageable);
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

}
