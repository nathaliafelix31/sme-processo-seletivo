/*package SistemaSME.services;

import SistemaSME.models.Usuario;
import SistemaSME.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {


    private UsuarioRepository usuarioRepository;

    public SSUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioRepository.findByUsername(username);
            if (usuario == null) {
                return null;
            }
            return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getSenha(), getAuthories(usuario));
        } catch (Exception e) {
            throw  new UsernameNotFoundException("Usuário não Encontrado!");
        }
    }
    private Set<GrantedAuthority> getAuthories(Usuario usuario){
        Set<GrantedAuthority> authorities  = new HashSet<>();
        for (Role role: usuario.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}*/