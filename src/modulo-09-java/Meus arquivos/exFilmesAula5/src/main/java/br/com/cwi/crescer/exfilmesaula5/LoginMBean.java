package br.com.cwi.crescer.exfilmesaula5;


import br.com.cwi.crescer.exfilmesaula5.bean.UsuarioBean;
import br.com.cwi.crescer.exfilmesaula5.entity.Usuario;
import br.com.cwi.crescer.exfilmesaula5.filters.User;
import br.com.cwi.crescer.exfilmesaula5.utils.FacesUtils;
import br.com.cwi.crescer.exfilmesaula5.utils.UserDetails;
import static br.com.cwi.crescer.exfilmesaula5.utils.UserDetails.USER_AUTH;
import java.io.Serializable;
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
public class LoginMBean implements Serializable {

    @EJB
    UsuarioBean usuarioBean;
    
    private User user;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoggedUsername() {
        final UserDetails emailDetails;
        emailDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return emailDetails == null ? null : emailDetails.getUsername();
    }

    public String login() {
        List<Usuario> usuarios = usuarioBean.findByEmail(this.user.getUsername());
        if (!usuarios.isEmpty()){
            Usuario usuario = usuarios.get(0);
            if (usuario.getSenha().equals(this.user.getPassword())){
                FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
                return "index";
            }
            
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dados de login invalidos", "Erro"));
        return "login";
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "logout";
    }
}
