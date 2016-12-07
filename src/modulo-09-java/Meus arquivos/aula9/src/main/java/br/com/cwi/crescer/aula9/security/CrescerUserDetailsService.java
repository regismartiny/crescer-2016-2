package br.com.cwi.crescer.aula9.security;

import br.com.cwi.crescer.aula9.entity.Usuario;
import br.com.cwi.crescer.aula9.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class CrescerUserDetailsService implements UserDetailsService {

    private static final String CRESCER = "crescer";
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        List<Usuario> users = usuarioService.findByEmail(username);
        if (!users.isEmpty()) {
            Usuario user = users.get(0);
            return new User(user.getEmail(), user.getSenha(), Roles.valuesToList());
        }
        //return null;
        return new User(username, new BCryptPasswordEncoder().encode(CRESCER), Roles.valuesToList());
    }

}
