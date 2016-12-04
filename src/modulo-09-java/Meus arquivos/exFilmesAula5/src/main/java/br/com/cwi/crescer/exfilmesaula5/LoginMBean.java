package br.com.cwi.crescer.exfilmesaula5;


import br.com.cwi.crescer.exfilmesaula5.filters.User;
import br.com.cwi.crescer.exfilmesaula5.utils.FacesUtils;
import br.com.cwi.crescer.exfilmesaula5.utils.UserDetails;
import static br.com.cwi.crescer.exfilmesaula5.utils.UserDetails.USER_AUTH;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class LoginMBean implements Serializable {

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
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getUsername();
    }

    public String login() {
        FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
        return "index";
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "logout";
    }
}
