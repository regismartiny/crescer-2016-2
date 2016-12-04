package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.bean.UsuarioBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author regis
 */
@ManagedBean
@ViewScoped
public class CadastroUsuario {

    @EJB
    private UsuarioBean usuarioBean;

    private Usuario usuario;
    private List<Usuario> usuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.usuarios = usuarioBean.findAll();
        this.usuarios.sort((a, b) -> a.getIdUsuario().compareTo(b.getIdUsuario()));
    }

    public void adicionar() {
        //validar email unico
        boolean valido = usuarioBean.findByEmail(this.usuario.getEmail()).isEmpty();
        if (valido) {
            usuarioBean.insert(usuario);
            this.init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro inserido com sucesso.", "OK"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email informado ja existe!", "Erro"));
        }
    }
}
